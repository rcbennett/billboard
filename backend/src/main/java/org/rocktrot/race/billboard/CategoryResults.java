package org.rocktrot.race.billboard;

import java.util.*;

public class CategoryResults {

    Category category;
    public List<Result> results;

    public CategoryResults(Category category) {
        this.category = category;
        results = new LinkedList<Result>();
    }

    public Category getCategory() {
        return category;
    }

    public List<Result> getResults() {
        return results;
    }
}
