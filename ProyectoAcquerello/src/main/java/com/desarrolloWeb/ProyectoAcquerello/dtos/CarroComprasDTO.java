package com.desarrolloWeb.ProyectoAcquerello.dtos;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

public class CarroComprasDTO {

    private Long id_CC;
    private Usuario usuarioc;
    private Plato platoc;
    private Integer cantidad;
    private float precio;


    /**
	 * @return the id_CC
	 */
    public Long getId_CC() {
        return id_CC;
    }


    /**
	 * @param id_CC the idPlato to set
	 */
    public void setId_CC(Long id_CC) {
        this.id_CC = id_CC;
    }


    /**
	 * @return the usuarioc
	 */
    public Usuario getUsuarioc() {
        return usuarioc;
    }

    
    /**
	 * @param usuarioc the idPlato to set
	 */
    public void setUsuarioc(Usuario usuarioc) {
        this.usuarioc = usuarioc;
    }


    /**
	 * @return the platoc
	 */
    public Plato getPlatoc() {
        return platoc;
    }

    
    /**
	 * @param platoc the idPlato to set
	 */
    public void setPlatoc(Plato platoc) {
        this.platoc = platoc;
    }


    /**
	 * @return the cantidad
	 */
    public Integer getCantidad() {
        return cantidad;
    }

    
    /**
	 * @param cantidad the idPlato to set
	 */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    /**
	 * @return the precio
	 */
    public float getPrecio() {
        return precio;
    }

    
    /**
	 * @param precio the idPlato to set
	 */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    
}
