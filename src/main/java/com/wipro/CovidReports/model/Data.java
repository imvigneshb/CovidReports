package com.wipro.CovidReports.model;

import java.util.Date;
import java.util.List;

public class Data {

    Date lastChecked;
    List<Covid19Stats> covid19Stats;

    public Date getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Date lastChecked) {
        this.lastChecked = lastChecked;
    }

    public List<Covid19Stats> getCovid19Stats() {
        return covid19Stats;
    }

    public void setCovid19Stats(List<Covid19Stats> covid19Stats) {
        this.covid19Stats = covid19Stats;
    }
}
