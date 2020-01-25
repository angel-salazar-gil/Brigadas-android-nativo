package com.example.myapplication.objetivo3.retrofit.Interface;

import com.example.myapplication.objetivo3.retrofit.Model.Brigadas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrigadasApi {

    @GET("/api/brigadas")
    Call<List<Brigadas>> getBrigadas();

}
