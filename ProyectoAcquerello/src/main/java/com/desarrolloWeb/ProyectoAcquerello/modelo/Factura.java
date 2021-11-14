package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    //En realidad es otra llave xd
    @Basic
    private Long idPlato;

    @ManyToOne
    private Usuario usuariof;

    @ManyToOne
    private Plato platof;
/*
    @Temporal(TemporalType.DATE)
    private Date fecha; */

    @Basic
    private Integer cantidad;

    @Basic
    private float total;


    //Constructor
    public Factura(){

    }
    
    

    public Long getIdPlato() {
        return idPlato;
    }



    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
    }



    public Usuario getUsuariof() {
        return usuariof;
    }



    public void setUsuariof(Usuario usuariof) {
        this.usuariof = usuariof;
    }



    public Plato getPlatof() {
        return platof;
    }



    public void setPlatof(Plato platof) {
        this.platof = platof;
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

    /*

    public Date getFecha(){
        return fecha;
    }  */

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

    /*
    public void setFecha(Date fecha){
        this.fecha = fecha;
    } */

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad ;
    } 
   
    public void setTotal(float total){
        this.total = total ;
    } 
    
}
