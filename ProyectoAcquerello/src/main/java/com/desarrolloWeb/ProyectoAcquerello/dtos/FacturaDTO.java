package com.desarrolloWeb.ProyectoAcquerello.dtos;

import java.util.Date;

public class FacturaDTO {

    private Long idFactura;
    private String nombreProducto;
    private UsuarioDTO usuariof;
    private PlatoDTO platof;
    private Date fecha;
    private Integer cantidad;
    private float total;
    private String foto;

    
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
    public UsuarioDTO getUsuariof() {
        return usuariof;
    }
    public void setUsuariof(UsuarioDTO usuariof) {
        this.usuariof = usuariof;
    }
    public PlatoDTO getPlatof() {
        return platof;
    }
    public void setPlatof(PlatoDTO platof) {
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
