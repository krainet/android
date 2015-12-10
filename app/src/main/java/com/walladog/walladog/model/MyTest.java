package com.walladog.walladog.model;

import org.json.JSONObject;

public class MyTest {

    private Boolean success;
    private double id;
    private String name;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTest(JSONObject json) {

        this.id = json.optDouble("id");
        this.name = json.optString("name");
        this.success = json.optBoolean("success");

    }

    @Override
    public String toString() {
        return "{id = "+id+", name = "+name+"}";
    }

}
