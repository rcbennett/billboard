package org.rocktrot.race.billboard;

import org.rocktrot.race.billboard.data.CategoryResults;
import org.rocktrot.race.billboard.data.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultsService {
    DataService data;

    public ResultsService() {
        data = new DataService();
    }

    @RequestMapping("/api/results")
    public List<CategoryResults> retrieveResults(){
        return data.results.getAllResults();
    }

    @PostMapping("/api/result")
    public void postResult(@RequestBody Result res){
        data.addResult(res);

    }
}
