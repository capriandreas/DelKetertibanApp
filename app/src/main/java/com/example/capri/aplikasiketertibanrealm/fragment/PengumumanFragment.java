package com.example.capri.aplikasiketertibanrealm.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.capri.aplikasiketertibanrealm.APIHasilPengumuman;
import com.example.capri.aplikasiketertibanrealm.MainActivity;
import com.example.capri.aplikasiketertibanrealm.R;
import com.example.capri.aplikasiketertibanrealm.RESTClient;
import com.example.capri.aplikasiketertibanrealm.ResponseHasilPengumuman;
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

public class PengumumanFragment extends Fragment {

    private ControllerHasilPengumuman controlHasilPengumuman;
    private Realm realm;
    RecyclerView recyclerView = null;
    private PengumumanAdapter pengumumanAdapters;
    private List<ModelPengumuman> mdlPengumuman;
    APIHasilPengumuman apiHasilPengumuman;

    public PengumumanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengumuman, container, false);

        mdlPengumuman = new ArrayList<ModelPengumuman>();
        controlHasilPengumuman = new ControllerHasilPengumuman();
        controlHasilPengumuman.deleteData();

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        try{
            realm = Realm.getDefaultInstance();
        }catch (Exception e){
            Toast.makeText(getActivity(), e.getMessage(),Toast.LENGTH_LONG).show();
        }
        settingRecyclerView();
        retrieveAllPengumuman();

        return view;
    }

    public void settingRecyclerView() {
        RealmResults<RealmPengumuman> hasil = realm.where(RealmPengumuman.class).findAll();

        pengumumanAdapters = new PengumumanAdapter(hasil, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(pengumumanAdapters);
        recyclerView.setHasFixedSize(true);
        pengumumanAdapters.notifyDataSetChanged();
//        settingRecyclerView();
//        retrieveAllPengumuman();
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
                        //
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseHasilPengumuman> call, Throwable t) {
                Toast.makeText(getActivity(), "Akses ke server gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        apiHasilPengumuman = RESTClient.get();
        Call<ResponseHasilPengumuman> calling = apiHasilPengumuman.getHasilPengumuman();
        calling.enqueue(getPeng);

    }

}
