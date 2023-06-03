package com.example.testdb.retrofit;

import com.example.testdb.model.Event;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface EventApi {
    @GET("/event/get-all")
    Call<List<Event>> getAllEvent();

    @POST("/event/save")
    Call<Event> save(@Body Event event);

    @POST("/event/change")
    Call<Event> changeEvent(@Body Event event);
}
