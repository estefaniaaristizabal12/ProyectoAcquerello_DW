package com.desarrolloWeb.ProyectoAcquerello.dtos;

import java.util.Date;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

public class FacturaDTO {

    private Long idFactura;
    private Usuario usuariof;
    private Plato platof;
    private Date fecha;
    private Integer cantidad;
    private float total;
    private String foto;
    private String nombrePlato;

    
    public String getNombrePlato() {
        return nombrePlato;
    }
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
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
