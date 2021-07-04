package com.example.responsi_123180125.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi_123180125.R;
import com.example.responsi_123180125.adapter.KasusAdapter;
import com.example.responsi_123180125.model.kasus.ContentItem;
import com.example.responsi_123180125.view.viewmodel.KasusViewModel;

import java.util.ArrayList;


public class KasusFragment extends Fragment {

    private KasusAdapter kasusAdapter;
    private RecyclerView RV_Kasus;
    private KasusViewModel kasusViewModel;

    public KasusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kasusAdapter = new KasusAdapter(getContext());
        kasusAdapter.notifyDataSetChanged();

        RV_Kasus = view.findViewById(R.id.fragmentkasus_rv);
        RV_Kasus.setLayoutManager(new GridLayoutManager(getContext(),1));

        kasusViewModel = new ViewModelProvider(this).get(KasusViewModel.class);
        kasusViewModel.setListDataKasus();
        kasusViewModel.getDataKasus().observe(this, getDataKasus);


        RV_Kasus.setAdapter(kasusAdapter);
    }

    private Observer<ArrayList<ContentItem>> getDataKasus = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> contentItems) {
            if (contentItems != null) {
                kasusAdapter.setData(contentItems);
            }
        }
    };
}