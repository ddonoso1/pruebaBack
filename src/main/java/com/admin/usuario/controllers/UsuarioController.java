package com.admin.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.admin.usuario.exceptions.UsuarioException;
import com.admin.usuario.jsons.CreateUsuariosRest;
import com.admin.usuario.jsons.RolesRest;
import com.admin.usuario.jsons.UsuariosRest;
import com.admin.usuario.responses.AdminUsuarioResponse;
import com.admin.usuario.services.RolService;
import com.admin.usuario.services.UsuarioService;

@RestController
@RequestMapping(path= "/api/firma")
public class UsuarioController {

		
	@Autowired
	UsuarioService usuarioService;
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "usuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminUsuarioResponse<List<UsuariosRest>> getUsuarios() throws UsuarioException {
		return new AdminUsuarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", usuarioService.getUsuarios());
	}
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "crearusuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminUsuarioResponse<String> crearUsuarios(@RequestBody CreateUsuariosRest createUsuariosRest) throws UsuarioException {
		return new AdminUsuarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", usuarioService.createUsuario(createUsuariosRest));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "actualizarusuario", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminUsuarioResponse<String> actualizarUsuarios(@RequestBody CreateUsuariosRest actualizarUsuariosRest) throws UsuarioException {
		return new AdminUsuarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", usuarioService.actualizarUsuario(actualizarUsuariosRest));
	}

	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "eliminarusuario", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminUsuarioResponse<String> eliminarUsuario(@RequestHeader Integer id_usuario) throws UsuarioException {
		return new AdminUsuarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", usuarioService.eliminarUsuario(id_usuario));
	}
	
}
