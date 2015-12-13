package com.walladog.walladog.model;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.walladog.walladog.model.interfaces.DAOPersistable;

import java.util.List;

/**
 * Created by hadock on 13/12/15.
 *
 */

public class Services implements DAOPersistable<Services> {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("name")
    private String name;

    @SerializedName("serviceImage")
    private String serviceImage;

    public String getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long insert(@NonNull Services data) {
        return 0;
    }

    @Override
    public void update(long id, @NonNull Services data) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(@NonNull Services data) {

    }

    @Override
    public void deleteAll() {

    }

    @Nullable
    @Override
    public Cursor queryCursor() {
        return null;
    }

    @Override
    public Services query(long id) {
        return null;
    }
}
