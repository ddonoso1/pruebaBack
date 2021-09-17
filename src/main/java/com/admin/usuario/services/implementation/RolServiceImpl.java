package com.admin.usuario.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.usuario.entities.Rol;
import com.admin.usuario.exceptions.UsuarioException;
import com.admin.usuario.jsons.RolesRest;
import com.admin.usuario.repositories.RolRepository;
import com.admin.usuario.services.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	RolRepository rolRepository;
	
	public static final ModelMapper modelMapper = new ModelMapper();
	
	public List<RolesRest> getRoles() throws UsuarioException{
		final List<Rol> rolesModel = rolRepository.findAll();
		return rolesModel.stream().map(service -> modelMapper.map(service, RolesRest.class)).collect(Collectors.toList());
	}
	
}
