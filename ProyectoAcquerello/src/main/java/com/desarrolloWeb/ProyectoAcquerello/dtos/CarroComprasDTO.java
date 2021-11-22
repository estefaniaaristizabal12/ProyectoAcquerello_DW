package com.desarrolloWeb.ProyectoAcquerello.dtos;

public class CarroComprasDTO {


    private Long _id_CC;
    private String _nombreProducto;
    private UsuarioDTO usuarioc;
    private PlatoDTO platoc;
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

    public UsuarioDTO getUsuarioc() {
        return usuarioc;
    }
    public void setUsuarioc(UsuarioDTO usuarioc) {
        this.usuarioc = usuarioc;
    }
    public PlatoDTO getPlatoc() {
        return platoc;
    }
    public void setPlatoc(PlatoDTO platoc) {
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
