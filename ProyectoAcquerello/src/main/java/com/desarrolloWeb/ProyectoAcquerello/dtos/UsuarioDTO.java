package com.desarrolloWeb.ProyectoAcquerello.dtos;

public class UsuarioDTO {
    

    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String contrasenia;

    
    /**
	 * @return the idUsuario
	 */
    public Long getIdUsuario() {
        return idUsuario;
    }
    	/**
	 * @param idUsuario the idUsuario to set
	 */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
	 * @return the apellido
	 */
    public String getApellido() {
        return apellido;
    }
    /**
	 * @param apellido the apellido to set
	 */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    
    /**
	 * @return the direccion
	 */
    public String getDireccion() {
        return direccion;
    }
    /**
	 * @param direccion the direccion to set
	 */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    /**
	 * @return the email
	 */
    public String getEmail() {
        return email;
    }
    /**
	 * @param email the email to set
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /**
	 * @return the contrasenia
	 */
    public String getContrasenia() {
        return contrasenia;
    }
    /**
	 * @param contrasenia the contrasenia to set
	 */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


}
