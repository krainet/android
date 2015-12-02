package com.dancingqueen.walladog.model;

public class Transaction {
    private long product;
    private long id;
    private String date_transaction;
    private long buyer;
    private long seller;

    public long getProduct () {
        return product;
    }

    public void setProduct (long product) {
        this.product = product;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getDate_transaction () {
        return date_transaction;
    }

    public void setDate_transaction (String date_transaction) {
        this.date_transaction = date_transaction;
    }

    public long getBuyer () {
        return buyer;
    }

    public void setBuyer (long buyer) {
        this.buyer = buyer;
    }

    public long getSeller () {
        return seller;
    }

    public void setSeller (long seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "{id = "+id+", product = "+product+", date_transaction = "+date_transaction+", buyer = "+buyer+", seller = "+seller+"}";
    }
}
