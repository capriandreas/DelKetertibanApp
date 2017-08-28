package com.example.capri.aplikasiketertibanrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capri.aplikasiketertibanrealm.adapter.PengumumanAdapter;
import com.example.capri.aplikasiketertibanrealm.controller.ControllerHasilPengumuman;
import com.example.capri.aplikasiketertibanrealm.model.ModelPengumuman;
import com.example.capri.aplikasiketertibanrealm.realm.RealmPengumuman;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPengumumanActivity extends AppCompatActivity {

    APIHasilPengumuman apiHasilPengumuman;
    private ModelPengumuman detail_pengumuman;
    private int id;
    public TextView judul, deskripsi, oleh, tanggal, status;
    private ControllerHasilPengumuman chp;
    private Realm realm;
    RecyclerView recyclerView = null;
    private PengumumanAdapter pengumumanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengumuman);
        setDetailPengumuman();

        Intent intent = getIntent();
        CharSequence getJudulIntent = intent.getStringExtra("judul");
        CharSequence getDeskripsiIntent = intent.getStringExtra("deskripsi");
        CharSequence getOlehIntent = intent.getStringExtra("oleh");
        CharSequence getTanggalIntent = intent.getStringExtra("tanggal");
        CharSequence getStatusIntent = intent.getStringExtra("status");
        id = intent.getIntExtra("id", 0);
        Toast.makeText(this, "Judul : " + getJudulIntent, Toast.LENGTH_SHORT).show();

        judul.setText(intent.getStringExtra("judul"));
        deskripsi.setText(intent.getStringExtra("deskripsi"));
        oleh.setText("Oleh : " + intent.getStringExtra("oleh"));
        tanggal.setText(intent.getStringExtra("tanggal"));
        status.setText("Status : "+ intent.getStringExtra("status"));

//        chp = new ControllerHasilPengumuman();
//        chp.deleteData();
//
//        try{
//            realm = Realm.getDefaultInstance();
//        }catch (Exception e){
//            Toast. makeText(getApplicationContext(),
//                    e.getMessage(),Toast. LENGTH_LONG).show();
//        }
//
//        getDetailPengumuman();
//        settingRecyclerView();
    }

//    private void getDetailPengumuman(){
//
//        Callback<ResponseDetailPengumuman> getDetailPengumuman = new Callback<ResponseDetailPengumuman>() {
//            @Override
//            public void onResponse(Call<ResponseDetailPengumuman> call, Response<ResponseDetailPengumuman> response) {
//                if(response.isSuccessful()){
//                    List<ModelPengumuman> mdlPengumuman = response.body().getDetailPengumuman();
//                    int jumlah_data = response.body().getDetailPengumuman().size();
//                    if(jumlah_data > 0){
//                        detail_pengumuman = mdlPengumuman.get(0);
//                        setDetailPengumuman(detail_pengumuman);
//                    }
//                    else {
//                        Toast.makeText(DetailPengumumanActivity.this, "Data tidak tersedia", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseDetailPengumuman> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Akses ke server gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        };
//
//
//        apiHasilPengumuman = RESTClient.get();
//        Call<ResponseDetailPengumuman>callback = apiHasilPengumuman.getDetailPengumuman(String.valueOf(id));
//        callback.enqueue(getDetailPengumuman);
//    }

    public void setDetailPengumuman(){
        judul = (TextView)findViewById(R.id.tvJudulDetail);
        deskripsi = (TextView)findViewById(R.id.tvDeskripsiDetail);
        oleh = (TextView)findViewById(R.id.tvOlehDetail);
        tanggal = (TextView)findViewById(R.id.tvTanggalDetail);
        status = (TextView)findViewById(R.id.tvStatusDetail);
    }

//    public void settingRecyclerView(){
//        RealmResults<RealmPengumuman> hasil = realm.where(RealmPengumuman.class).findAll();
//
//        pengumumanAdapter = new PengumumanAdapter(hasil, getApplicationContext());
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(pengumumanAdapter);
//        recyclerView.setHasFixedSize(true);
//    }
}
