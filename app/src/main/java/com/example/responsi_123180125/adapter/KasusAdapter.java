package com.example.responsi_123180125.adapter;

import android.content.Context;
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
import com.example.responsi_123180125.model.kasus.ContentItem;

import java.util.ArrayList;
import java.util.Collections;

public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.viewHolder> {

    private ArrayList<ContentItem> contentItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<ContentItem> items){
        contentItems.clear();
        Collections.reverse(items);
        contentItems.addAll(items);
        notifyDataSetChanged();
    }

    public KasusAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public KasusAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_kasus,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusAdapter.viewHolder holder, int position) {
        holder.TVtanggal.setText(contentItems.get(position).getTanggal());
        holder.TVterkonfirmasi.setText(String.valueOf(contentItems.get(position).getConfirmationDiisolasi()));
        holder.TVsembuh.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()));
        holder.TVmeninggal.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()));

    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView TVtanggal, TVsembuh, TVmeninggal, TVterkonfirmasi;
        CardView CVItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            CVItem = itemView.findViewById(R.id.itemlistkasus_cv);
            TVtanggal = itemView.findViewById(R.id.tv_tanggal);
            TVterkonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
            TVsembuh= itemView.findViewById(R.id.tv_sembuh);
            TVmeninggal = itemView.findViewById(R.id.tv_meninggal);

        }
    }
}
