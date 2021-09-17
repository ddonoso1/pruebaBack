package com.admin.usuario.services;

import java.util.List;

import com.admin.usuario.exceptions.UsuarioException;
import com.admin.usuario.jsons.RolesRest;

public interface RolService {

	public List<RolesRest> getRoles() throws UsuarioException;
	
	
}
