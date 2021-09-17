package com.admin.usuario.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.usuario.entities.Rol;
import com.admin.usuario.entities.Usuario;
import com.admin.usuario.exceptions.UsuarioException;
import com.admin.usuario.jsons.CreateUsuariosRest;
import com.admin.usuario.jsons.UsuariosRest;
import com.admin.usuario.repositories.RolRepository;
import com.admin.usuario.repositories.UsuarioRepository;
import com.admin.usuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	
	
	@Autowired
	RolRepository rolRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public static final ModelMapper modelMapper = new ModelMapper();
	
	public List<UsuariosRest> getUsuarios() throws UsuarioException{
		final List<Usuario> usuariosModel = usuarioRepository.findAll();
		return usuariosModel.stream().map(service -> modelMapper.map(service, UsuariosRest.class)).collect(Collectors.toList());
	}


	public String createUsuario(CreateUsuariosRest createUsuariosRest) throws UsuarioException {
		final Rol rolId = rolRepository.findByIdRol(createUsuariosRest.getIdRol());
		final Usuario usuario = new Usuario();
		usuario.setNombre_usuario(createUsuariosRest.getNombre());
		usuario.setActivo(createUsuariosRest.getActivo());
		usuario.setRol(rolId);
		
		try {
			if(usuarioRepository.findByNombre(usuario.getNombre()) == null) {
				usuarioRepository.save(usuario);
			}else {
				return "El usuario ya existe";
			}
		} catch (Exception e) {
			return "No se puede crear el usuario";
		}
		return usuario.getNombre();
	}
	
	public String actualizarUsuario(CreateUsuariosRest createUsuariosRest) throws UsuarioException {
		final Rol rolId = rolRepository.findByIdRol(createUsuariosRest.getIdRol());
		Usuario usuario = usuarioRepository.findByIdUsuario(createUsuariosRest.getIdUsuario());
		usuario.setNombre_usuario(createUsuariosRest.getNombre());
		usuario.setActivo(createUsuariosRest.getActivo());
		usuario.setRol(rolId);
		
		try {
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			//LOGGER.error("ERROR EN EL SERVIDOR", e);
		}
		return usuario.getNombre();
	}

	
	public String eliminarUsuario(Integer id_usuario) throws UsuarioException {
		final Usuario usuario = usuarioRepository.findByIdUsuario(id_usuario);
		try {
			usuarioRepository.deleteByIdUsuario(id_usuario);
		} catch (Exception e) {

		}
		return "Usuario eliminado: " + usuario.getNombre();
	}
	
	
	
}
