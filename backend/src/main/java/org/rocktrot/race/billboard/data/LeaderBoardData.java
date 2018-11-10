package org.rocktrot.race.billboard.data;

import java.util.List;

public class LeaderBoardData {

    List<CategoryResults> results;
    long timestamp;

    public LeaderBoardData(List<CategoryResults> results, long timestamp) {
        this.results = results;
        this.timestamp = timestamp;
    }

    public List<CategoryResults> getResults() {
        return results;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
