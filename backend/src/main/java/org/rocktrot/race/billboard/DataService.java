package org.rocktrot.race.billboard;

public class DataService {
    public ResultData results;

    public DataService() {
        results = new ResultData();
        CategoryResults catRes;

        catRes = new CategoryResults(new Category("Men 40+","men40"));
        catRes.results.add(new Result("Jacob Vargish","e404","23:02",23,2));
        catRes.results.add(new Result("Michael Kulish","e404","25:02",25,2));
        catRes.results.add(new Result("Damon Edmund","e404","34:02",34,2));
        catRes.results.add(new Result("Rob Bennett","e404","37:02",37,2));
        results.allResults.add(catRes);

        catRes = new CategoryResults(new Category("Women 40+","women40"));
        catRes.results.add(new Result("Tara Vargish","e404","23:02",23,2));
        catRes.results.add(new Result("Nicky Kulish","e404","25:02",25,2));
        catRes.results.add(new Result("Jenn Bennett","e404","34:02",34,2));
        catRes.results.add(new Result("Lily Othersby","e404","37:02",37,2));
        results.allResults.add(catRes);


    }


}
