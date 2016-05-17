package org.vcmo.thisgoods.utils.rest;

import org.vcmo.thisgoods.model.action.LoginR;
import org.vcmo.thisgoods.model.data.MainListData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Jie on 2016-05-13.
 */
public interface RestAPI {

    @POST("user/login")
    String login(@Body LoginR login);


    @GET("fetch")
    Call<MainListData> fetchData();
}
