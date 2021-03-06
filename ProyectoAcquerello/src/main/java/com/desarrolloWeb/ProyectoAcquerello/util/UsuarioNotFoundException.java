package com.desarrolloWeb.ProyectoAcquerello.util;

public class UsuarioNotFoundException  extends RuntimeException{

    public UsuarioNotFoundException(Long id) {
		super("No se encontrĂ³ el usuario con id :" + id);
	}
	
	public UsuarioNotFoundException(String identificacion) {
		super("No se encontrĂ³ el usuario con id :" + identificacion);
	}
    
}
