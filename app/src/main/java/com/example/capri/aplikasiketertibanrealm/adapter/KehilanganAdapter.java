package com.example.capri.aplikasiketertibanrealm.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import com.example.capri.aplikasiketertibanrealm.R;
import com.example.capri.aplikasiketertibanrealm.realm.RealmKehilangan;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by capri on 5/16/2017.
 */

public class KehilanganAdapter extends RealmRecyclerViewAdapter<RealmKehilangan, KehilanganAdapter.ViewHolder>{

    Context mContext;

    public KehilanganAdapter(OrderedRealmCollection<RealmKehilangan> data, Context mContext){
        super(data, true);
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kehilangan, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RealmKehilangan obj = getItem(position);
        holder.barang.setText(obj.getBarang());
        holder.deskripsi.setText(obj.getDeskripsi());
        holder.oleh.setText(obj.getOleh());
        holder.tanggal.setText(obj.getTanggal());
        holder.waktu.setText(obj.getWaktu());
        holder.daerah.setText(obj.getDaerah());
        holder.gambar.setText(obj.getGambar());

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView barang;
        public TextView deskripsi;
        public TextView oleh;
        public TextView tanggal;
        public TextView waktu;
        public TextView daerah;
        public TextView gambar;
        public CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view_kehilangan);
            barang = (TextView)itemView.findViewById(R.id.tvBarang2);
            oleh = (TextView)itemView.findViewById(R.id.tvOleh2);
//            deskripsi = (TextView)itemView.findViewById(R.id.tvDeskripsi2);
//            tanggal = (TextView)itemView.findViewById(R.id.tvTanggal2);
//            waktu = (TextView)itemView.findViewById(R.id.tvWaktu2);
//            daerah = (TextView)itemView.findViewById(R.id.tvDaerah2);
//            gambar = (TextView)itemView.findViewById(R.id.tvGambar2);
        }
    }
}
