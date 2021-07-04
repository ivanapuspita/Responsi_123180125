package com.example.responsi_123180125.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_123180125.model.faskes.DataItem;
import com.example.responsi_123180125.model.faskes.FaskesResponse;
import com.example.responsi_123180125.model.kasus.ContentItem;
import com.example.responsi_123180125.model.kasus.KasusResponse;
import com.example.responsi_123180125.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<ContentItem>> listDataKasus = new MutableLiveData<ArrayList<ContentItem>>();

    public void setListDataKasus() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApi().getDataKasus().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse kasusResponse = response.body();
                if (kasusResponse != null && kasusResponse.getData() != null) {

                    ArrayList<ContentItem> contentItems = kasusResponse.getData().getContent();

                    listDataKasus.postValue(contentItems);
                    Log.d("KasusViewModel", "onSuccess: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {
                Log.e("KasusViewModel", "onFailure: "+t.getMessage());

            }

        });
    }
    public LiveData<ArrayList<ContentItem>> getDataKasus(){
        return listDataKasus;
    }
}
