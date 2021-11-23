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
    @JoinColumn(name = "usuarioId", referencedColumnName = "_idUsuario")
    private Usuario usuariof;

    @ManyToOne
    @JoinColumn(name = "platoId", referencedColumnName = "_idPlato")
    private Plato platof;

    @Basic
    private String foto;

    
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic
    private Integer cantidad;

    @Basic
    private float total;

    @Basic
    private String nombrePlato;


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

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    } 
}