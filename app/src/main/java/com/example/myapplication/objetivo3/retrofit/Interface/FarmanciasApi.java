package com.example.myapplication.objetivo3.retrofit.Interface;

import com.example.myapplication.objetivo3.retrofit.Model.Farmancias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FarmanciasApi {

    @GET("/api/farmancias")
    Call<List<Farmancias>> getFarmancias();

}
