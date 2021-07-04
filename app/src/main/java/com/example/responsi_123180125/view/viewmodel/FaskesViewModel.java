package com.example.responsi_123180125.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_123180125.model.faskes.DataItem;
import com.example.responsi_123180125.model.faskes.FaskesResponse;
import com.example.responsi_123180125.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaskesViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listDataFaskes = new MutableLiveData<ArrayList<DataItem>>();

    public void setListDataFaskes() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApi().getDataFaskes().enqueue(new Callback<FaskesResponse>() {
            @Override
            public void onResponse(Call<FaskesResponse> call, Response<FaskesResponse> response) {
                FaskesResponse faskesResponse = response.body();
                if (faskesResponse != null && faskesResponse.getData() != null) {

                    ArrayList<DataItem> dataItem = faskesResponse.getData();

                    listDataFaskes.postValue(dataItem);
                    Log.d("FaskesViewModel", "onSuccess: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<FaskesResponse> call, Throwable t) {
                Log.e("FaskesViewModel", "onFailure: "+t.getMessage());

            }

        });
    }
    public LiveData<ArrayList<DataItem>> getDataFaskes(){
        return listDataFaskes;
    }



}
