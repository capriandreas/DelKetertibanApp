package com.example.capri.aplikasiketertibanrealm.controller;

import android.util.Log;

import com.example.capri.aplikasiketertibanrealm.realm.RealmPengumuman;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by capri on 5/16/2017.
 */

public class ControllerHasilPengumuman {

    private final Realm realm;
    private static ControllerHasilPengumuman instance;

    public ControllerHasilPengumuman(){realm = Realm.getDefaultInstance();}
    public Realm getRealm() {return realm; }

    public void insertData(final int id, final String judul, final String deskripsi, final String oleh, final String tanggal, final String status){
        try
        {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmPengumuman realmPengumuman = realm.createObject(RealmPengumuman.class, id);
                    realmPengumuman.setJudul(judul);
                    realmPengumuman.setDeskripsi(deskripsi);
                    realmPengumuman.setOleh(oleh);
                    realmPengumuman.setTanggal(tanggal);
                    realmPengumuman.setStatus(status);
                }
            });
        }catch (Exception e){
            Log.e("Error : ", e.getMessage());
        }
    }

    public void deleteData(){
        try{
            realm.beginTransaction();
            RealmResults<RealmPengumuman> pengumuman = realm.where(RealmPengumuman.class).findAll();
            pengumuman.deleteAllFromRealm();
            realm.commitTransaction();
        }catch (Exception e){
            Log.e("Error : ", e.getMessage());
        }
    }
}
