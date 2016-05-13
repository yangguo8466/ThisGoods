package org.vcmo.thisgoods.utils.rest;

import org.vcmo.thisgoods.model.action.LoginR;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Jie on 2016-05-13.
 */
public interface RestAPI {

    @POST("user/login")
    String login(@Body LoginR login);


}
