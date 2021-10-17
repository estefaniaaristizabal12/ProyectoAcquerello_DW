package com.desarrolloWeb.ProyectoAcquerello.util;

@SuppressWarnings("serial")
public class PlatoNotFoundException extends RuntimeException {

	public PlatoNotFoundException(Long id) {
		super("Could not find team by id:" + id);
	}
	
	public PlatoNotFoundException(String identificacion) {
		super("Could not find team by identificacion:" + identificacion);
	}
}