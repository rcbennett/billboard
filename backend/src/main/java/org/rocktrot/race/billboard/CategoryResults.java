package org.rocktrot.race.billboard;

import java.util.*;

public class CategoryResults {

    Category category;
    public List<Result> mensResults;
    public List<Result> womensResults;

    public CategoryResults(Category category) {
        this.category = category;
        mensResults = new LinkedList<Result>();
        womensResults = new LinkedList<Result>();
    }

    public Category getCategory() {
        return category;
    }

    public List<Result> getWomensResults() {
        return womensResults;
    }

    public List<Result> getMensResults() {
        return mensResults;
    }
}
