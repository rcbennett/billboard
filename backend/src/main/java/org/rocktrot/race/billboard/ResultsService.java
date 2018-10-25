package org.rocktrot.race.billboard;

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
        return data.results.allResults;
    }

    @PostMapping("/api/result")
    public void postResult(@RequestBody Result res){
        data.addResult(res);

    }
}
