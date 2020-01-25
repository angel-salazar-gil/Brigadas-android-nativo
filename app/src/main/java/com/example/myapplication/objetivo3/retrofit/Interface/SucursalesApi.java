package com.example.myapplication.objetivo3.retrofit.Interface;

import com.example.myapplication.objetivo3.retrofit.Model.Sucursales;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SucursalesApi {

    @GET("/api/sucursales")
    Call<List<Sucursales>> getSucursales();

}
