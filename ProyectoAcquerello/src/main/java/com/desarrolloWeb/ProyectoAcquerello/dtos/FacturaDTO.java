package com.desarrolloWeb.ProyectoAcquerello.dtos;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

public class FacturaDTO {

    private Long idFactura;
    private Usuario usuariof;
    private Plato platof;
    private Integer cantidad;
    private float total;


    
    /**
	 * @return the idFactura
	 */
    public Long getIdFactura() {
        return idFactura;
    }

    /**
	 * @param idFactura the idFactura to set
	 */
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    
    /**
	 * @return the usuariof
	 */
    public Usuario getUsuariof() {
        return usuariof;
    }

    /**
	 * @param usuariof the usuariof to set
	 */
    public void setUsuariof(Usuario usuariof) {
        this.usuariof = usuariof;
    }

    
    /**
	 * @return the platof
	 */
    public Plato getPlatof() {
        return platof;
    }

    /**
	 * @param platof the platof to set
	 */
    public void setPlatof(Plato platof) {
        this.platof = platof;
    }

    
    /**
	 * @return the cantidad
	 */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
	 * @param cantidad the cantidad to set
	 */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    /**
	 * @return the total
	 */
    public float getTotal() {
        return total;
    }

    /**
	 * @param total the total to set
	 */
    public void setTotal(float total) {
        this.total = total;
    }

    
}
