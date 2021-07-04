package com.example.responsi_123180125.service;

import com.example.responsi_123180125.model.faskes.FaskesResponse;
import com.example.responsi_123180125.model.kasus.KasusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getDataKasus();

    @GET("sebaran_v2/jabar/faskes")
    Call<FaskesResponse> getDataFaskes();

}
