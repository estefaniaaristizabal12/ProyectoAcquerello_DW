package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class IdFactura implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFactura;

    Long idProducto;

    public IdFactura(Long idFacturax, Long idProducto) {
        this.idFactura= idFacturax;
        this.idProducto = idProducto;
    }

    public Long getIdFacturax() {
        return idFactura;
    }

    public void setIdFacturax(Long idFacturax) {
        this.idFactura = idFacturax;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    

}
