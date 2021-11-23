package com.desarrolloWeb.ProyectoAcquerello.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UsuarioNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(UsuarioNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String providerNotFoundHandler(UsuarioNotFoundException ex) {
		return ex.getMessage();
	}
}
