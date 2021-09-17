package com.admin.usuario.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.admin.usuario.entities.Rol;
import com.admin.usuario.entities.Usuario;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

	Rol findByIdRol(Integer idRol);
	
	List<Rol> findAll();
	
}
