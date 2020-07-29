package com.example.rss_reader;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class DataList extends ExpandableGroup<Child> {

    private String name;
    private String home;
    private String picture;

    public DataList(String name,String home, String picture, List<Child> items) {
        super(name, items);
        this.home = home;
        this.name = name;
        this.picture = picture;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
