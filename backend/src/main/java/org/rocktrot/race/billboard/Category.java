package org.rocktrot.race.billboard;

public class Category {
    String name;
    String id;
    int ageMin;
    int ageMax;

    public Category(String name, String id, int ageMin, int ageMax) {
        this.name = name;
        this.id = id;
        this.ageMax = ageMax;
        this.ageMin = ageMin;
    }

    public String getName() {
        return name;
    }



    public String getId() {
        return id;
    }


}
