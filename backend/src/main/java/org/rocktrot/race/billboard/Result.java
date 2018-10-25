package org.rocktrot.race.billboard;

import java.util.Objects;

public class Result implements Comparable<Result>{
    String name;
    String id;
    String timeString;
    String gender;
    private int hours;
    private int mins;
    private int seconds;
    private int totSecs;
    int age;


    public Result() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(id, result.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Result(String name, String id, int age, String gender, String timeString) {
        this.name = name;
        this.id = id;
        this.timeString = timeString;
        this.age = age;


        int idx = timeString.lastIndexOf(":");
        String secStr = timeString.substring(idx+1);
        seconds = Integer.parseInt(secStr);
        timeString = timeString.substring(0,idx);

        idx = timeString.lastIndexOf(":");
        if(idx >=0) {
            secStr = timeString.substring(idx + 1);
            timeString = timeString.substring(0,idx);
        } else {
            secStr = timeString;
            timeString = "0";
        }
        mins = Integer.parseInt(secStr);


        idx = timeString.lastIndexOf(":");
        if(idx > 0) {
            secStr = timeString.substring(idx+1);
            hours = Integer.parseInt(secStr);
        }
        totSecs = (this.hours * 60 * 60 ) + (this.mins * 60) + this.seconds;

        this.gender = gender;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
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


    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getTotSecs() {
        return totSecs;
    }

    public void setTotSecs(int totSecs) {
        this.totSecs = totSecs;
    }

    @Override
    public int compareTo(Result o) {
        return this.totSecs - o.totSecs;
    }
}
