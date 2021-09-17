package com.admin.usuario.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.admin.usuario.dtos.ErrorDto;

@SuppressWarnings("serial")
public class InternalServerError extends UsuarioException {

	public InternalServerError(String code, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
	public InternalServerError(String code, String message, ErrorDto data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}
