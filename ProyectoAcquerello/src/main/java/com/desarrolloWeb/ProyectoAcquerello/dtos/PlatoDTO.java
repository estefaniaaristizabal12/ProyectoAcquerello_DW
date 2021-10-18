package com.desarrolloWeb.ProyectoAcquerello.dtos;

public class PlatoDTO {

    private Long _idPlato;
    private String _nombre;
    private String _descripcion;
    private String _imagen;
    private float _precio;


    public Long get_idPlato() {
        return _idPlato;
    }
    public void set_idPlato(Long _idPlato) {
        this._idPlato = _idPlato;
    }
    public String get_nombre() {
        return _nombre;
    }
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    public String get_descripcion() {
        return _descripcion;
    }
    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    
    public String get_imagen() {
        return _imagen;
    }
    public void set_imagen(String _imagen) {
        this._imagen = _imagen;
    }
    public float get_precio() {
        return _precio;
    }
    public void set_precio(float _precio) {
        this._precio = _precio;
    }


  
    
}
