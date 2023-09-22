package com.alura.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.dto.UsuarioDTO;
import com.alura.foro.dto.UsuarioDTOget;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping
	public void registrarTopico(@RequestBody @Valid UsuarioDTO usuario) {
		usuarioRepository.save(new Usuario(usuario));
	}
	
	@GetMapping
	public List<UsuarioDTOget> ListadoUsuarios () {
		return usuarioRepository.findAll().stream().map(UsuarioDTOget::new).toList();
	}
	

}
