package com.vikcandroid.retrofitdemo.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * To send network requests to an API, we need to use the Retrofit Builder class and specify the base URL for the service.
 * Here BASE_URL – it is basic URL of our API. We will use this URL for all requests later
 */
public class ApiClient {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
