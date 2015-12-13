package com.walladog.walladog.model.apiservices;

import com.walladog.walladog.model.Services;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by hadock on 10/12/15.
 *
 */


public interface ServicesService {

    String apiEndpoint = "/services";

    @GET(apiEndpoint)
    Call<List<Services>> getMultiTask();

    @GET(apiEndpoint+"/{id}")
    Call<Services> getOneTask();

    @POST(apiEndpoint)
    Call<Services> postTask(@Body Services data);

    @PUT(apiEndpoint+"/{id}")
    Call<Services> putTask(@Path("id") String id, @Body Services data);

    @DELETE(apiEndpoint+"/{id}")
    Call deleteTask(@Path("id") String id);


}