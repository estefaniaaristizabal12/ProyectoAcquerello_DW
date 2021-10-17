package com.desarrolloWeb.ProyectoAcquerello.dtos;

public class PlatoDTO {

    private Long idPlato;
    private String nombre;
    private String descripcion;
    private float precio;


    /**
	 * @return the idPlato
	 */
    public Long getIdPlato() {
        return idPlato;
    }


    
	/**
	 * @param idPlato the idPlato to set
	 */
    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
    }

    
    /**
	 * @return the nombre
	 */
    public String getNombre() {
        return nombre;
    }


    /**
	 * @param nombre the nombre to set
	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
	 * @return the descripcion
	 */
    public String getDescripcion() {
        return descripcion;
    }

    
    /**
	 * @param descripcion the descripcion to set
	 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
	 * @return the precio
	 */
    public float getPrecio() {
        return precio;
    }

    /**
	 * @param precio the precio to set
	 */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

  
    
}
