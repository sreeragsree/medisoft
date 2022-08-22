package com.example.medisoft.Retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    //API CLIENT WITH BASE + APPEND URL for http connection via RETROFIT LIBRARY FOR ACCESSING  NETWORK CALLS
    static Retrofit retrofit = null;

    public static String baseUrl = "http://www.futurerightwings.com/";
    public static final String APPEND_URL = "pdftest/Api.php?apicall=";

    public static Api getInterface() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(Api.class);
    }

}