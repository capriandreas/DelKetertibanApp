package com.example.capri.aplikasiketertibanrealm;

import com.example.capri.aplikasiketertibanrealm.model.ModelPengumuman;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by capri on 5/16/2017.
 */

public class ResponseHasilPengumuman {
    private String error;
    private List<ModelPengumuman> pengumuman;

    public String getError(){
        return error;
    }

    public void setError(String error){
        this.error = error;
    }

    public List<ModelPengumuman> getHasil(){
        return pengumuman;
    }

    public void setHasil(List<ModelPengumuman> pengumuman){
        this.pengumuman = pengumuman;
    }
}
