package org.rocktrot.race.billboard;

import org.rocktrot.race.billboard.data.Category;
import org.rocktrot.race.billboard.data.CategoryResults;
import org.rocktrot.race.billboard.data.Result;
import org.rocktrot.race.billboard.data.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {
    public ResultData results;
    Map<Integer, CategoryResults> catAgeMap;
    CategoryResults overallLeaders;
    long latestTimestamp;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public DataService() {
        latestTimestamp = 0;
        results = new ResultData();
        catAgeMap = new HashMap<Integer, CategoryResults>();


        // overall leaders
        overallLeaders = new CategoryResults(new Category("Overall", "over", 0, 200));
        results.getAllResults().add(overallLeaders);

        configureCategory("12 & Under", "12u", 0, 12);
        configureCategory("13 - 19", "13-19", 13, 19);
        configureCategory("20 - 29", "2029", 20, 29);
        configureCategory("30 - 39", "3039", 30, 39);
        configureCategory("40 - 49", "4049", 40, 49);
        configureCategory("50 - 59", "5059", 50, 59);
        configureCategory("60 - 69", "6069", 60, 69);
        configureCategory("70 & over", "70up", 70, 200);

    }

    private void configureCategory(String catName, String catId, int minAge, int maxAge) {
        CategoryResults catRes;

        catRes = new CategoryResults(new Category(catName, catId, minAge, maxAge));
        results.getAllResults().add(catRes);
        for (int i = minAge; i <= maxAge; i++) {
            catAgeMap.put(i, catRes);
        }
    }


    public void addResult(Result result) {
        // figure out the category
        CategoryResults catRes = catAgeMap.get(result.getAge());
        List<Result> resultList;
        List<Result> leaderList;
        Result oldLeader = null;

        if (result.getGender().equalsIgnoreCase("M")) {
            resultList = catRes.mensResults;
            leaderList = overallLeaders.mensResults;
        } else {
            resultList = catRes.womensResults;
            leaderList = overallLeaders.womensResults;
        }

        if (!leaderList.contains(result)) {
            boolean isLeader = false;
            if (leaderList.size() >= 3) {
                oldLeader = leaderList.get(leaderList.size() - 1);
                if (result.compareTo(oldLeader) < 0) {
                    log.info("Leader Bump!!!");
                    log.info("Adding entry for [" + result.getName() + "] to overall leaders");
                    leaderList.add(result);
                    isLeader = true;
                    result = oldLeader;
                    log.info("Inserting [" + result.getName() + "] into age bracket leaders");
                }
            } else {
                isLeader = true;
                log.info("Adding entry for [" + result.getName() + "] to overall leaders");
                leaderList.add(result);
            }
            if (!isLeader || oldLeader != null) {
                if (!resultList.contains(result)) {
                    boolean canAdd = false;
                    if (resultList.size() >= 3) {
                        Result other = resultList.get(resultList.size() - 1);
                        if (result.compareTo(other) < 0) {
                            canAdd = true;
                        }
                    } else {
                        canAdd = true;
                    }
                    if (canAdd) {
                        log.info("Adding entry for [" + result.getName() + "] to age bracket [" + catRes.getCategory().getName() + "]");
                        resultList.add(result);
                        Collections.sort(resultList);
                        while (resultList.size() > 3) {
                            resultList.remove(3);
                        }
                    }
                }
            }
        } // no need for an else if they are already in the leader list

    }

    public void reset() {
        results.reset();
        latestTimestamp = System.currentTimeMillis();
    }
}
