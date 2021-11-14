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

    
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic
    private Integer cantidad;

    @Basic
    private float total;


    public Factura(){

    }


    public Long getIdFactura() {
        return idFactura;
    }


    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
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


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public float getTotal() {
        return total;
    }


    public void setTotal(float total) {
        this.total = total;
    }


    
}