package com.example.myapplication.objetivo3.retrofit.Model;

public class Sucursales {

    private String _id;
    private String descripcion;
    private String horario;
    private Number telefono;
    private String direccion;
    private String imagen;
    private String latitud;
    private String longitud;

    public Sucursales(String _id, String descripcion, String horario, Number telefono, String direccion, String imagen, String latitud, String longitud) {
        this._id = _id;
        this.descripcion = descripcion;
        this.horario = horario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String get_id() {
        return _id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public Number getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }
}
