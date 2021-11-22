package com.desarrolloWeb.ProyectoAcquerello.modelo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Factura {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuariof;

    @ManyToOne
    @JoinColumn(name = "plato_id")
    private Plato platof;

    @Basic
    private String foto;

    
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic
    private Integer cantidad;

    @Basic
    private float total;


    public Factura(){

    }
    
    


    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
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