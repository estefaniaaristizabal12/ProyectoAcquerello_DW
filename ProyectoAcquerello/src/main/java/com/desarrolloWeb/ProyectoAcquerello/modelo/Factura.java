package com.desarrolloWeb.ProyectoAcquerello.modelo;


import javax.persistence.Entity;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.List;

import javax.persistence.Basic;
=======
=======
>>>>>>> parent of 4eaeae8 (funcionalcito)
import javax.persistence.ManyToOne;


import javax.persistence.Basic;
import javax.persistence.EmbeddedId;

>>>>>>> parent of 4eaeae8 (funcionalcito)

@Entity
public class Factura{

<<<<<<< HEAD
=======
    @EmbeddedId
    IdFactura id;
    /*
>>>>>>> parent of 4eaeae8 (funcionalcito)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @ManyToMany
    private List<Plato> platosf;  //Una factura tiene muchos platos

    @ManyToOne
    private Usuario usuariof;

    @ManyToOne
    private Plato platof;

    private Integer cantidad;

    @Basic
    private float total;


    //Constructor
    public Factura(){

    }


    public Long getIdFactura() {
        return idFactura;
    }


    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }


    public List<Plato> getPlatosf() {
        return platosf;
    }


    public void setPlatosf(List<Plato> platosf) {
        this.platosf = platosf;
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


    public List<Integer> getCantidad() {
        return cantidad;
    }


    public void setCantidad(List<Integer> cantidad) {
        this.cantidad = cantidad;
    }


    public float getTotal() {
        return total;
    }


    public void setTotal(float total) {
        this.total = total;
    }

    

    
}


