package com.desarrolloWeb.ProyectoAcquerello.util;

public class UsuarioNotFoundException  extends RuntimeException{

    public UsuarioNotFoundException(Long id) {
		super("No se encontró el usuario con id :" + id);
	}
	
	public UsuarioNotFoundException(String identificacion) {
		super("No se encontró el usuario con id :" + identificacion);
	}
    
}
