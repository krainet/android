package com.walladog.walladog.model.apiservices;

import com.walladog.walladog.model.Events;

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


public interface EventsService {

    String apiEndpoint = "/events";

    @GET(apiEndpoint)
    Call<List<Events>> getMultiTask();

    @GET(apiEndpoint+"/{id}")
    Call<Events> getOneTask();

    @POST(apiEndpoint)
    Call<Events> postTask(@Body Events data);

    @PUT(apiEndpoint+"/{id}")
    Call<Events> putTask(@Path("id") String id , @Body Events data);

    @DELETE(apiEndpoint+"/{id}")
    Call deleteTask(@Path("id") String id);


}