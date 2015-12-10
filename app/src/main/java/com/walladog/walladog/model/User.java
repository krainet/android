package com.walladog.walladog.model;

import org.json.*;


public class User {

    private Detail detail;
    private String password;
    private double id;
    private String lastname;
    private String company;
    private String firstname;
    private String email;


    public User () {

    }

    public User (JSONObject json) {

        this.detail = new Detail(json.optJSONObject("detail"));
        this.password = json.optString("password");
        this.id = json.optDouble("id");
        this.lastname = json.optString("lastname");
        this.company = json.optString("company");
        this.firstname = json.optString("firstname");
        this.email = json.optString("email");

    }

    public Detail getDetail() {
        return this.detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getId() {
        return this.id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{id = "+id+", detail = "+detail+", email = "+email+", lastname = "+lastname+", firstname = "+firstname+", password = "+password+"}";
    }

}
