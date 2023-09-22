package com.alura.foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
