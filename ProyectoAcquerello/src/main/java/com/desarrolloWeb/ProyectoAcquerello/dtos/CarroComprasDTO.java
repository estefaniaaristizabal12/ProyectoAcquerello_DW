package com.desarrolloWeb.ProyectoAcquerello.dtos;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

public class CarroComprasDTO {


    private Long _id_CC;
    private String _nombreProducto;
    private Usuario usuarioc;
    private Plato platoc;
    private String _foto;
    private Integer _cantidad;
    private float _precio;

    
    public Long get_id_CC() {
        return _id_CC;
    }
    public void set_id_CC(Long _id_CC) {
        this._id_CC = _id_CC;
    }
    public String get_nombreProducto() {
        return _nombreProducto;
    }
    public void set_nombreProducto(String _nombreProducto) {
        this._nombreProducto = _nombreProducto;
    }
    public Usuario getUsuarioc() {
        return usuarioc;
    }
    public void setUsuarioc(Usuario usuarioc) {
        this.usuarioc = usuarioc;
    }
    public Plato getPlatoc() {
        return platoc;
    }
    public void setPlatoc(Plato platoc) {
        this.platoc = platoc;
    }
    public String get_foto() {
        return _foto;
    }
    public void set_foto(String _foto) {
        this._foto = _foto;
    }
    public Integer get_cantidad() {
        return _cantidad;
    }
    public void set_cantidad(Integer _cantidad) {
        this._cantidad = _cantidad;
    }
    public float get_precio() {
        return _precio;
    }
    public void set_precio(float _precio) {
        this._precio = _precio;
    }

    


    
    
}
