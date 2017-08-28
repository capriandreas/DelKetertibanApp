package com.example.capri.aplikasiketertibanrealm;

import com.example.capri.aplikasiketertibanrealm.model.ModelPengumuman;

import java.util.List;

/**
 * Created by capri on 5/17/2017.
 */

public class ResponseDetailPengumuman {
    private String error;
    private List<ModelPengumuman> pengumuman;

    public String getError(){
        return error;
    }

    public void setError(String error){
        this.error = error;
    }

    public List<ModelPengumuman> getDetailPengumuman(){
        return pengumuman;
    }

    public void setHasil(List<ModelPengumuman> pengumuman){
        this.pengumuman = pengumuman;
    }
}
