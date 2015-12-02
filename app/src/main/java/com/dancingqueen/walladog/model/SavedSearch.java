package com.dancingqueen.walladog.model;

public class SavedSearch {

    private long id;
    private String keywords;
    private long raceId;
    private long categoryId;
    private long userId;
    private double longitude;
    private double latitude;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getKeywords ()  {
        return keywords;
    }

    public void setKeywords (String keywords) {
        this.keywords = keywords;
    }

    public long getRaceId () {
        return raceId;
    }

    public void setRaceId (long raceId) {
        this.raceId = raceId;
    }

    public long getCategoryId () {
        return categoryId;
    }

    public void setCategoryId (long categoryId) {
        this.categoryId = categoryId;
    }

    public long getUserId () {
        return userId;
    }

    public void setUserId (long userId) {
        this.userId = userId;
    }

    public double getLongitude () {
        return longitude;
    }

    public void setLongitude (double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude ()  {
        return latitude;
    }

    public void setLatitude (double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "{id = "+id+", keywords = "+keywords+", raceId = "+raceId+", categoryId = "+categoryId+", userId = "+userId+", longitude = "+longitude+", latitude = "+latitude+"}";
    }
}