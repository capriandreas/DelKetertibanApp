package com.example.capri.aplikasiketertibanrealm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.capri.aplikasiketertibanrealm.fragment.KehilanganFragment;
import com.example.capri.aplikasiketertibanrealm.fragment.PengumumanFragment;

/**
 * Created by capri on 5/17/2017.
 */

public class TabFragmentPagerPengumuman extends FragmentPagerAdapter {

    //nama tab nya
    String[] title = new String[]{
            "Pengumuman", "Kehilangan"
    };

    public TabFragmentPagerPengumuman(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new PengumumanFragment();
                break;
            case 1:
                fragment = new KehilanganFragment();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
