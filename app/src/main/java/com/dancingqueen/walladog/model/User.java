package com.dancingqueen.walladog.model;



public class User {
    private long id;
    private Detail detail;
    private String username;
    private String email;
    private String lastname;
    private String firstname;
    private String password;

    public User(String jsonString) {
        
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public Detail getDetail () {
        return detail;
    }

    public void setDetail (Detail detail) {
        this.detail = detail;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getLastname () {
        return lastname;
    }

    public void setLastname (String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname () {
        return firstname;
    }

    public void setFirstname (String firstname) {
        this.firstname = firstname;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{id = "+id+", detail = "+detail+", username = "+username+", email = "+email+", lastname = "+lastname+", firstname = "+firstname+", password = "+password+"}";
    }
}