package com.example.capri.aplikasiketertibanrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.capri.aplikasiketertibanrealm.adapter.PengumumanAdapter;
import com.example.capri.aplikasiketertibanrealm.controller.ControllerHasilPengumuman;
import com.example.capri.aplikasiketertibanrealm.model.ModelPengumuman;
import com.example.capri.aplikasiketertibanrealm.realm.RealmPengumuman;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ControllerHasilPengumuman controlHasilPengumuman;
    private Realm realm;
    RecyclerView recyclerView = null;
    private PengumumanAdapter pengumumanAdapter;
    private List<ModelPengumuman> mdlPengumuman;
    APIHasilPengumuman apiHasilPengumuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdlPengumuman = new ArrayList<ModelPengumuman>();
        controlHasilPengumuman = new ControllerHasilPengumuman();
        controlHasilPengumuman.deleteData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        try{
            realm = Realm.getDefaultInstance();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
        }
        settingRecyclerView();
        retrieveAllPengumuman();
    }

        public void settingRecyclerView(){
            RealmResults<RealmPengumuman> hasil = realm.where(RealmPengumuman.class).findAll();

        pengumumanAdapter = new PengumumanAdapter(hasil, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pengumumanAdapter);
        recyclerView.setHasFixedSize(true);
    }

    public void retrieveAllPengumuman(){
        Callback<ResponseHasilPengumuman> getPeng = new Callback<ResponseHasilPengumuman>(){

            @Override
            public void onResponse(Call<ResponseHasilPengumuman> call, Response<ResponseHasilPengumuman> response) {
                if(response.isSuccessful()){
                    List<ModelPengumuman> modPengumuman  = response.body().getHasil();
                    int jumlah_data = response.body().getHasil().size();
                    if(jumlah_data > 0){
                        for(int j = 0; j<jumlah_data;j++){
                            ModelPengumuman mdlpengumuman = modPengumuman.get(j);
                            controlHasilPengumuman.insertData(mdlpengumuman.getId(), mdlpengumuman.getJudul(), mdlpengumuman.getDeskripsi(), mdlpengumuman.getOleh(), mdlpengumuman.getTanggal(), mdlpengumuman.getStatus());
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Data tidak ada",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseHasilPengumuman> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Akses ke server gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        apiHasilPengumuman = RESTClient.get();
        Call<ResponseHasilPengumuman> calling = apiHasilPengumuman.getHasilPengumuman();
        calling.enqueue(getPeng);

    }
}
