package com.dancingqueen.walladog.model;

public class Detail
{
    private String facebook_token;
    private String avatar_url;
    private double longitude;
    private double latitude;

    protected Detail(){

    }

    public String getFacebook_token () {
        return facebook_token;
    }

    public void setFacebook_token (String facebook_token) {
        this.facebook_token = facebook_token;
    }

    public String getAvatar_url () {
        return avatar_url;
    }

    public void setAvatar_url (String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public double getLongitude () {
        return longitude;
    }

    public void setLongitude (double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude () {
        return latitude;
    }

    public void setLatitude (double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "[facebook_token = "+facebook_token+", avatar_url = "+avatar_url+", longitude = "+longitude+", latitude = "+latitude+"]";
    }
}
