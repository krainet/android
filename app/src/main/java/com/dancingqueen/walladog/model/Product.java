package com.dancingqueen.walladog.model;

public class Product {
    private String published_date;
    private long id;
    private long category;
    private float price;
    private boolean sterile;
    private String description;
    private String name;
    private long state;
    private String gender;
    private long seller;
    private long race;

    public String getPublished_date () {
        return published_date;
    }

    public void setPublished_date (String published_date) {
        this.published_date = published_date;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public long getCategory () {
        return category;
    }

    public void setCategory (long category) {
        this.category = category;
    }

    public float getPrice () {
        return price;
    }

    public void setPrice (float price) {
        this.price = price;
    }

    public boolean getSterile () {
        return sterile;
    }

    public void setSterile (boolean sterile) {
        this.sterile = sterile;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public long getState () {
        return state;
    }

    public void setState (long state) {
        this.state = state;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public long getSeller () {
        return seller;
    }

    public void setSeller (long seller) {
        this.seller = seller;
    }

    public long getRace () {
        return race;
    }

    public void setRace (long race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "{id = "+id+", published_date = "+published_date+",  category = "+category+", price = "+price+", sterile = "+sterile+", description = "+description+", name = "+name+", state = "+state+", gender = "+gender+", seller = "+seller+", race = "+race+"}";
    }
}
