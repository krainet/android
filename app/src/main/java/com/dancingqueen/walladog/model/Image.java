package com.dancingqueen.walladog.model;


public class Image {
    private long id;
    private String name;
    private String photoUrl;
    private long productId;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPhotoUrl () {
        return photoUrl;
    }

    public void setPhotoUrl (String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public long getProductId () {
        return productId;
    }

    public void setProductId (long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "{id = "+id+", name = "+name+", photoUrl = "+photoUrl+", productId = "+productId+"}";
    }
}

