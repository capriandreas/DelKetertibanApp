package com.example.capri.aplikasiketertibanrealm;

import com.example.capri.aplikasiketertibanrealm.model.ModelKehilangan;

import java.util.List;

/**
 * Created by capri on 5/16/2017.
 */

public class ResponseHasilKehilangan {
    private String error;
    private List<ModelKehilangan> kehilangan;

    public String getError(){
        return error;
    }

    public void setError(String error){
        this.error = error;
    }

    public List<ModelKehilangan> getHasil2(){
        return kehilangan;
    }

    public void setHasil2(List<ModelKehilangan> kehilangan){
        this.kehilangan = kehilangan;
    }
}
