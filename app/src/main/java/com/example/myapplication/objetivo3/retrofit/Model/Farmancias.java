package com.example.myapplication.objetivo3.retrofit.Model;

public class Farmancias {

    private String imagen;
    private String farmancia;
    private String direccion;
    private String longitud;
    private String latitud;

    public Farmancias(String imagen, String farmancia, String direccion, String longitud, String latitud) {
        this.imagen = imagen;
        this.farmancia = farmancia;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getImagen() {
        return imagen;
    }

    public String getFarmancia() {
        return farmancia;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLatitud() {
        return latitud;
    }
}
