package com.admin.usuario.services;

import java.util.List;

import com.admin.usuario.exceptions.UsuarioException;
import com.admin.usuario.jsons.CreateUsuariosRest;
import com.admin.usuario.jsons.UsuariosRest;

public interface UsuarioService {

	public List<UsuariosRest> getUsuarios() throws UsuarioException;
	
	public String createUsuario(CreateUsuariosRest CreateUsuariosRest) throws UsuarioException;
	
	public String actualizarUsuario(CreateUsuariosRest CreateUsuariosRest) throws UsuarioException;
	
	public String eliminarUsuario(Integer id_usuario) throws UsuarioException;
}
