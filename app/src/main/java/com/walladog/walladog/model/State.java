package com.walladog.walladog.model;

import org.json.JSONObject;


public class State {

    private double id;
    private String name;


    public State () {

    }

    public State (JSONObject json) {

        this.id = json.optDouble("id");
        this.name = json.optString("name");

    }

    public double getId() {
        return this.id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{id = "+id+", name = "+name+"}";
    }
}
