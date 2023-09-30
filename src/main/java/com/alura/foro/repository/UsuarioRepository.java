package com.alura.foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.alura.foro.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//Nota para evitar error el nombre despues de "findby" debe ser igual al campor de la entidad.
	UserDetails findByNombre(String username);

}
