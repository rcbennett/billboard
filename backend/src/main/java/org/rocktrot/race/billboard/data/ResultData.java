package org.rocktrot.race.billboard.data;

import java.util.*;

public class ResultData {
    List<CategoryResults> allResults;

    public ResultData() {
        this.allResults = new LinkedList<>();
    }

    public List<CategoryResults> getAllResults() {
        return allResults;
    }

    public void reset(){
        for (CategoryResults result:allResults) {
            result.reset();
        }
    }
}
