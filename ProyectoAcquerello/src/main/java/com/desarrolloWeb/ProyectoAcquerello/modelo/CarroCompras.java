package com.desarrolloWeb.ProyectoAcquerello.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import javax.persistence.Basic;
//import javax.persistence.EmbeddedId;


@Entity
public class CarroCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_CC;

    //@EmbeddedId
    @ManyToOne
    private Usuario usuarioc;

    @ManyToOne
    private Plato platoc;

    @Basic
    private Integer cantidad;

    @Basic
    private float precio;


     //Constructor
     public CarroCompras(){

    }


    //Getter
    public Long getIdCC(){
        return id_CC;
    } 

    public Plato getPlato(){
        return platoc;
    }

    public Usuario getUsuario(){
        return usuarioc;
    }

    public Integer getCantidad(){
        return cantidad;
    }

    public float getPrecio(){
        return precio;
    } 

    //Setter

    public void setIdFactura(Long idCC){
        this.id_CC = idCC ;
    } 
    
    public void setPlato(Plato plato){
        this.platoc = plato ;
    } 
    public void setUsuario(Usuario usuario){
        this.usuarioc = usuario ;
    } 

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad ;
    } 
   
    public void setPrecio(float precio){
        this.precio = precio ;
    }   
}
