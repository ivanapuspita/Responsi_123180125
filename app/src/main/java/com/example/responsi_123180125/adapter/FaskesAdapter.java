package com.example.responsi_123180125.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_123180125.R;
import com.example.responsi_123180125.model.faskes.DataItem;

import java.util.ArrayList;
import java.util.Collections;

public class FaskesAdapter extends RecyclerView.Adapter<FaskesAdapter.viewHolder> {

    private ArrayList<DataItem> dataItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<DataItem> items){
        dataItem.clear();
        Collections.reverse(items);
        dataItem.addAll(items);
        notifyDataSetChanged();
    }

    public FaskesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_faskes,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.TVFaskes.setText(String.valueOf(dataItem.get(position).getNama()));
        holder.TVAlamat.setText(String.valueOf(dataItem.get(position).getAlamat()));
        holder.BTNMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri Intent = Uri.parse("geo: " + dataItem.get(position).getLatitude() + "," + dataItem.get(position).getLongitude() + "?q=" + Uri.encode(dataItem.get(position).getNama()));
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Intent);
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView TVFaskes, TVAlamat;
        Button BTNMaps;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            TVFaskes = itemView.findViewById(R.id.tv_faskes);
            TVAlamat= itemView.findViewById(R.id.tv_alamat);
            BTNMaps = itemView.findViewById(R.id.btn_maps);
        }
    }
}
