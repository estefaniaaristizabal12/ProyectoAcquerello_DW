package com.desarrolloWeb.ProyectoAcquerello.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Basic;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlato;

    @Basic
    private String nombre;

    @Basic
    private String descripcion;

    @Basic
    private float precio;


    //Constructor
    public Plato(){

    }

    //Getter
    public Long getId(){
        return idPlato;
    } 

    public String getNombre(){
        return nombre;
    } 

    public String getDescripcion(){
        return descripcion;
    }

    public float getPrecio(){
        return precio;
    } 

    //Setter
    public void setId(Long idPlato){
        this.idPlato = idPlato ;
    } 

    public void setNombre(String nombre){
        this.nombre = nombre ;
    } 
   
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion ;
    } 

    public void setPrecio(float precio){
        this.precio = precio ;
    } 
    
    
}
