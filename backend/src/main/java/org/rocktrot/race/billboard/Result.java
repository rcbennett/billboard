package org.rocktrot.race.billboard;

public class Result {
    String name;
    String id;
    String timeString;
    int mins;
    int seconds;

    public Result(String name, String id, String timeString, int mins, int seconds) {
        this.name = name;
        this.id = id;
        this.timeString = timeString;
        this.mins = mins;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTimeString() {
        return timeString;
    }

    public int getMins() {
        return mins;
    }

    public int getSeconds() {
        return seconds;
    }
}
