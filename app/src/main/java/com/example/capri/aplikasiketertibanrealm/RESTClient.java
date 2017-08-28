package com.example.capri.aplikasiketertibanrealm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by capri on 5/16/2017.
 */

public class RESTClient {
    private static APIHasilPengumuman REST_CLIENT;

    static {
        setupRestClient();
    }

    private RESTClient(){
    }

    public static APIHasilPengumuman get(){
        return REST_CLIENT;
    }
    public static void setupRestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.219.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        REST_CLIENT = retrofit.create(APIHasilPengumuman.class);
    }
}
