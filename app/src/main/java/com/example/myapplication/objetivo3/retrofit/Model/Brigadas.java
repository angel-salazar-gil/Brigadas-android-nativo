package com.example.myapplication.objetivo3.retrofit.Model;

public class Brigadas {

    private String _id;
    private String tipo;
    private String descripcion;
    private String horario;
    private String direccion;
    private String imagen;
    private String latitud;
    private String longitud;

    public Brigadas(String _id, String tipo, String descripcion, String horario, String direccion, String imagen, String latitud, String longitud) {
        this._id = _id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.horario = horario;
        this.direccion = direccion;
        this.imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String get_Id() {
        return _id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHorario() {
        return horario;
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
