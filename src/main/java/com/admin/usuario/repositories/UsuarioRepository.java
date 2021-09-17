package com.admin.usuario.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.admin.usuario.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByIdUsuario(Integer idUsuario);
	
	@Modifying
	@Transactional
	Optional<Usuario> deleteByIdUsuario(Integer idUsuario);
	Usuario findByNombre(String nombre);
	List<Usuario> findAll();
	
	

}
