package com.desarrolloWeb.ProyectoAcquerello.util;

@SuppressWarnings("serial")
public class PlatoNotFoundException extends RuntimeException {

	public PlatoNotFoundException(Long id) {
		super("No se encontrĂ³ el plato con id :" + id);
	}
	
	public PlatoNotFoundException(String identificacion) {
		super("No se encontrĂ³ el plato con id :" + identificacion);
	}
}