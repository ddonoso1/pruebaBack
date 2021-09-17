package com.admin.usuario.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.admin.usuario.dtos.ErrorDto;

@SuppressWarnings("serial")
public class UsuarioException extends Exception{
	
	private final String code;
	
	private final int responseCode;
	
	private final List<ErrorDto> errorList = new ArrayList<>();

	public UsuarioException(String code, int responseCode, String message) {
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public UsuarioException(String code, int responseCode, Integer message) {
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public UsuarioException(String code, int responseCode, String message, List<ErrorDto> errorList) {
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDto> getErrorList() {
		return errorList;
	}
	
	
	
}
