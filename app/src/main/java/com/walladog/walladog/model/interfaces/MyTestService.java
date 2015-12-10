package com.walladog.walladog.model.interfaces;

import com.walladog.walladog.model.MyTest;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by hadock on 10/12/15.
 *
 */

public interface MyTestService {
    @GET("/events")
    Call<List<MyTest>> getTasks();
}