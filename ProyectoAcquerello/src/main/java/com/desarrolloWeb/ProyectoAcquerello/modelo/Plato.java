package com.desarrolloWeb.ProyectoAcquerello.modelo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.Id;
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


    //Constructor
    public Plato(){

    }

    //Getter
    public Long getId(){
        return _idPlato;
    } 

    public String getNombre(){
        return _nombre;
    } 

    public String getDescripcion(){
        return _descripcion;
    }

    public float getPrecio(){
        return _precio;
    } 

    //Setter
    public void setId(Long idPlato){
        this._idPlato = idPlato ;
    } 

    public void setNombre(String nombre){
        this._nombre = nombre ;
    } 
   
    public void setDescripcion(String descripcion){
        this._descripcion = descripcion ;
    } 

    public void setPrecio(float precio){
        this._precio = precio ;
    } 
    
    
}
