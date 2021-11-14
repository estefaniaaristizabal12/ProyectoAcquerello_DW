package com.desarrolloWeb.ProyectoAcquerello.modelo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Basic;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _idPlato;

    @Basic
    private String _nombre;

    @Basic
    private String _descripcion;

    @Basic
    private String _imagen;

    @Basic
    private float _precio;

  
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "platof")
    private List<Factura> facturas;  //Un usuario tiene muchas facturas

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "platoc")
    private List<CarroCompras> carroCompras;  //Un usuario tiene muchos productos en un carro de compras 


    
    public Plato() {
    }


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


    public List<Factura> getFacturas() {
        return facturas;
    }


    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }


    public List<CarroCompras> getCarroCompras() {
        return carroCompras;
    }


    public void setCarroCompras(List<CarroCompras> carroCompras) {
        this.carroCompras = carroCompras;
    }


  
    
}
