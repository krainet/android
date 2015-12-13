package com.walladog.walladog.model;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.walladog.walladog.model.apiservices.ServicesService;
import com.walladog.walladog.model.interfaces.DAOPersistable;

import java.io.Serializable;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hadock on 13/12/15.
 *
 */

public class Services implements DAOPersistable<Services>,Serializable {

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

/*    public void getApiServices(final ProgressDialog dialog) {

        ServicesService testService = ServiceGenerator.createService(ServicesService.class);
        Call<List<Services>> call = testService.getMultiTask();

        call.enqueue(new Callback<List<Services>>() {
            @Override
            public void onResponse(Response<List<Services>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.v("API-JSON:", response.body().toString());
                    List<Services> test = response.body();
                    Log.v("ANDROID-OBJECT", test.toString());
                    Log.v("FIRST NAME:", String.valueOf(test.get(0).getName()));
                    dialog.dismiss();

                } else {
                    Log.v("RAMON", "Sin respuesta");
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // something went completely south (like no internet connection)
                dialog.dismiss();
                Log.d("Error", t.getMessage());
            }
        });

    }*/

}
