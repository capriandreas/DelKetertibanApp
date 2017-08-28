package com.example.capri.aplikasiketertibanrealm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.capri.aplikasiketertibanrealm.DetailPengumumanActivity;
import com.example.capri.aplikasiketertibanrealm.R;
import com.example.capri.aplikasiketertibanrealm.model.ModelPengumuman;
import com.example.capri.aplikasiketertibanrealm.realm.RealmPengumuman;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by capri on 5/16/2017.
 */

public class PengumumanAdapter extends RealmRecyclerViewAdapter<RealmPengumuman, PengumumanAdapter.ViewHolder> {

    Context mContext;

    public PengumumanAdapter(OrderedRealmCollection<RealmPengumuman> data, Context mContext){
        super(data,true);
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengumuman, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RealmPengumuman obj = getItem(position);
        holder.judul.setText(obj.getJudul());
        holder.status.setText("Status : "+obj.getStatus());
        holder.oleh.setText("Oleh : "+obj.getOleh());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetailPengumumanActivity.class);
                intent.putExtra("id", obj.getId());
                intent.putExtra("judul", obj.getJudul());
                intent.putExtra("deskripsi", obj.getDeskripsi());
                intent.putExtra("oleh", obj.getOleh());
                intent.putExtra("tanggal", obj.getTanggal());
                intent.putExtra("status", obj.getStatus());
                v.getContext().startActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView judul;
        public TextView oleh;
        public TextView status;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view_pengumuman);
            judul = (TextView) itemView.findViewById(R.id.tvJudul1);
            oleh = (TextView) itemView.findViewById(R.id.tvOleh1);
            status = (TextView) itemView.findViewById(R.id.tvStatus1);
    }

    }
}
