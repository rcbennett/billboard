package org.rocktrot.race.billboard;

import java.util.*;

public class ResultData {
    List<CategoryResults> allResults;

    public ResultData() {
        this.allResults = new LinkedList<>();
    }

    public List<CategoryResults> getAllResults() {
        return allResults;
    }
}
