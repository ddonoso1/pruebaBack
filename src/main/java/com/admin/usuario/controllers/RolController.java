package com.admin.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.admin.usuario.exceptions.UsuarioException;
import com.admin.usuario.jsons.RolesRest;
import com.admin.usuario.responses.AdminUsuarioResponse;
import com.admin.usuario.services.RolService;

@RestController
@RequestMapping(path= "/api/firma")
public class RolController {
	
	@Autowired
	RolService rolService;
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminUsuarioResponse<List<RolesRest>> getRoles() throws UsuarioException {
		return new AdminUsuarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", rolService.getRoles());
	}
	
	
}
