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
import com.example.responsi_123180125.adapter.FaskesAdapter;
import com.example.responsi_123180125.model.faskes.DataItem;
import com.example.responsi_123180125.view.viewmodel.FaskesViewModel;

import java.util.ArrayList;

public class FaskesFragment extends Fragment {

    private FaskesAdapter faskesAdapter;
    private RecyclerView RV_Faskes;
    private FaskesViewModel faskesViewModel;

    public FaskesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_faskes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        faskesAdapter = new FaskesAdapter(getContext());
        faskesAdapter.notifyDataSetChanged();

        RV_Faskes = view.findViewById(R.id.fragmentfaskes_rv);
        RV_Faskes.setLayoutManager(new GridLayoutManager(getContext(),1));

        faskesViewModel = new ViewModelProvider(this).get(FaskesViewModel.class);
        faskesViewModel.setListDataFaskes();
        faskesViewModel.getDataFaskes().observe(this, getDataFaskes);


        RV_Faskes.setAdapter(faskesAdapter);
    }

    private Observer<ArrayList<DataItem>> getDataFaskes = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null) {
                faskesAdapter.setData(dataItems);
            }
        }
    };
}