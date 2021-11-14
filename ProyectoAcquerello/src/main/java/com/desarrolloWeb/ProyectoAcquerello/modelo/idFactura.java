package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class IdFactura implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFacturax;

    Long idProducto;

    public IdFactura(Long idFacturax, Long idProducto) {
        this.idFacturax = idFacturax;
        this.idProducto = idProducto;
    }

    public Long getIdFacturax() {
        return idFacturax;
    }

    public void setIdFacturax(Long idFacturax) {
        this.idFacturax = idFacturax;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    

}
