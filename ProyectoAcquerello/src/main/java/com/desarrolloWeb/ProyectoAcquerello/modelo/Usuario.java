package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Entity;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _idUsuario;

    @Basic
    private String _email;

    @Basic
    private String _nombre;

    @Basic
    private String _apellido;

    @Basic
    private String _direccion;

    @Basic
    private String _contrasenia;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuariof")
    private List<Factura> facturas;  //Un usuario tiene muchas facturas

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioc")
    private List<CarroCompras> carroCompras;  //Un usuario tiene muchos productos en un carro de compras 

    //Constructor
    public Usuario(){

    }

    public Long get_idUsuario() {
        return _idUsuario;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_direccion() {
        return _direccion;
    }

    public void set_direccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String get_contrasenia() {
        return _contrasenia;
    }

    public void set_contrasenia(String _contrasenia) {
        this._contrasenia = _contrasenia;
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
