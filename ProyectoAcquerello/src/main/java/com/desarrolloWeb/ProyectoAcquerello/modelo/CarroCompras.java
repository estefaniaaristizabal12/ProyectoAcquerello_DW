package com.desarrolloWeb.ProyectoAcquerello.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import javax.persistence.Basic;
//import javax.persistence.EmbeddedId;


@Entity
public class CarroCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id_CC;

    @Basic
    private String _nombreProducto;

    @ManyToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "_idUsuario")
    private Usuario usuarioc;

    @ManyToOne
    @JoinColumn(name = "platoId", referencedColumnName = "_idPlato")
    private Plato platoc;
    
    @Basic
    private String _foto;

    @Basic
    private Integer _cantidad;

    @Basic
    private float _precio;


     //Constructor
     public CarroCompras(){

    }


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
