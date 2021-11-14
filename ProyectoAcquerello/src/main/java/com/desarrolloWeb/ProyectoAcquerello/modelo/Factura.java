package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Basic;
//import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


@Entity
public class Factura {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @ManyToOne
    private Usuario usuariof;

    @ManyToOne
    private Plato platof;


    @Basic
    private Integer cantidad;

    @Basic
    private float total;


    //Constructor
    public Factura(){

    }
    
    //Getter
    public Long getIdFactura(){
        return idFactura;
    } 

    public Integer getCantidad(){
        return cantidad;
    }

    public float getTotal(){
        return total;
    } 

  

    public Plato getPlato(){
        return platof;
    }

    public Usuario getUsuario(){
        return usuariof;
    }

    //Setter

    public void setIdFactura(Long idFactura){
        this.idFactura = idFactura ;
    } 

    public void setPlato(Plato plato){
        this.platof = plato ;
    } 
    public void setUsuario(Usuario usuario){
        this.usuariof = usuario ;
    } 

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad ;
    } 
   
    public void setTotal(float total){
        this.total = total ;
    } 
    
}