package com.example.capri.aplikasiketertibanrealm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by capri on 5/16/2017.
 *
 */

public interface APIHasilPengumuman {

    @POST("/tugaspribadi/pam/pengumuman")
    Call<ResponseHasilPengumuman> getHasilPengumuman();

    @GET("/tugaspribadi/pam/pengumuman/{id}")
    Call<ResponseDetailPengumuman> getDetailPengumuman(@Path("id") String id);

    @POST("/tugaspribadi/pam/kehilangan")
    Call<ResponseHasilPengumuman> getHasilKehilangan();
}
