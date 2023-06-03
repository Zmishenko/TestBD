package com.example.testdb.retrofit;

import com.example.testdb.model.User;
import com.squareup.okhttp.ResponseBody;

import java.util.Optional;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface UserApi {
    @GET("/authentication/login/{login}/{password}")
    Call<User> authentication(@Path("login") String login, @Path("password") String password);
//    @POST("/authentication/login")
//    Call<User> authentication (@Body User user);
}
