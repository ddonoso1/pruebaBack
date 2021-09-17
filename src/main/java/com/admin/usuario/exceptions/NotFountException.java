package com.admin.usuario.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.admin.usuario.dtos.ErrorDto;

@SuppressWarnings("serial")
public class NotFountException extends UsuarioException {

	public NotFountException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}
	
	public NotFountException(String code, String message, ErrorDto data) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}

}
