package org.vcmo.thisgoods.utils.rest;

import org.vcmo.thisgoods.base.common.Common;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jie on 2016-05-13.
 */
public class RestFactory {
    private static Map<Class, Object> rests = new HashMap<>();

    public static <T> T createRest(Class<T> restClass) {

        T rest = (T) rests.get(restClass);

        if (rest == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Common.BASE_URI)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            rest = retrofit.create(restClass);
        }

        return rest;
    }
}
