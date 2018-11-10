package org.rocktrot.race.billboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {
    public ResultData results;
    Map<Integer,CategoryResults> catAgeMap;

    public DataService() {
        results = new ResultData();
        catAgeMap = new HashMap<Integer, CategoryResults>();
        CategoryResults catRes;

        configureCategory("12 & Under","12u",0,12);
        configureCategory("13 - 19","13-19",13,19);
        configureCategory("20 - 29","2029",20,29);
        configureCategory("30 - 39","3039",30,39);
        configureCategory("40 - 49","4049",40,49);
        configureCategory("50 - 59","5059",50,59);
        configureCategory("60 - 69","6069",60,69);
        configureCategory("70 & over","70up",70,200);

    }

    private void configureCategory(String catName, String catId, int minAge, int maxAge){
        CategoryResults catRes;

        catRes = new CategoryResults(new Category(catName,catId,minAge,maxAge));
        results.allResults.add(catRes);
        for(int i = minAge; i <= maxAge; i++){
            catAgeMap.put(i,catRes);
        }
    }



    public void addResult(Result result){
        // figure out the category
        CategoryResults catRes = catAgeMap.get(result.age);
        List<Result> resultList;
        if(result.gender.equalsIgnoreCase("M")){
            resultList = catRes.mensResults;
        } else {
            resultList = catRes.womensResults;
        }
        if(!resultList.contains(result)) {
            boolean canAdd = false;
            if(resultList.size() >=3){
                Result other = resultList.get(resultList.size() - 1);
                if(result.compareTo(other) < 0){
                    canAdd = true;
                }
            } else {
                canAdd = true;
            }
            if(canAdd) {
                System.out.println("Adding entry for [" + result.name + "]");
                resultList.add(result);
                Collections.sort(resultList);
                while (resultList.size() > 3) {
                    resultList.remove(3);
                }
            }
        }
    }
}
