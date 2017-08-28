package com.example.capri.aplikasiketertibanrealm.controller;

import android.util.Log;

import com.example.capri.aplikasiketertibanrealm.realm.RealmKehilangan;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by capri on 5/16/2017.
 */

public class ControllerHasilKehilangan {

    private final Realm realm;
    private static ControllerHasilKehilangan instance;

    public ControllerHasilKehilangan(){realm = Realm.getDefaultInstance();}
    public Realm getRealm() {return realm;}

    public void insertData(final int idkehilangan, final String barang, final String deskripsi, final String oleh, final String tanggal, final String waktu, final String daerah, final String gambar){
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmKehilangan realmKehilangan = realm.createObject(RealmKehilangan.class, idkehilangan);
                    realmKehilangan.setBarang(barang);
                    realmKehilangan.setDeskripsi(deskripsi);
                    realmKehilangan.setOleh(oleh);
                    realmKehilangan.setTanggal(tanggal);
                    realmKehilangan.setWaktu(waktu);
                    realmKehilangan.setDaerah(daerah);
                    realmKehilangan.setGambar(gambar);
                }
            });
        }catch (Exception e){
            Log.e("Error : ", e.getMessage());
        }
    }

    public void deleteData(){
        try {
            realm.beginTransaction();
            RealmResults<RealmKehilangan> kehilangen = realm.where(RealmKehilangan.class).findAll();
            kehilangen.deleteAllFromRealm();
            realm.commitTransaction();
        }catch (Exception e){
            Log.e("Error : ", e.getMessage());
        }
    }

}
