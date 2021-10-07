package com.desarrolloWeb.ProyectoAcquerello.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Basic;

@Entity
public class CarroCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCC;

    @OneToOne 
    private Usuario usuario;

    @OneToMany
    private List<Plato> plato;

    @Basic
    private Integer cantidad;

    @Basic
    private float precio;


     //Constructor
     public CarroCompras(){

    }


    //Getter
    public Long getIdCC(){
        return idCC;
    } 


    public Usuario getUsuario(){
        return usuario;
    } 

    public Integer getCantidad(){
        return cantidad;
    }

    public float getPrecio(){
        return precio;
    } 

    //Setter

    public void setIdFactura(Long idCC){
        this.idCC = idCC ;
    } 

    public void setIdUsuario(Usuario usuario){
        this.usuario = usuario ;
    } 


    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad ;
    } 
   
    public void setPrecio(float precio){
        this.precio = precio ;
    }   
}
