package com.alura.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.dto.UsuarioDTOlogin;
import com.alura.foro.infra.security.TokenService;
import com.alura.foro.infra.security.UsuarioDTOjwt;
import com.alura.foro.modelo.Usuario;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
@Tag(
		name = "Autenticacion",
		description = "obtiene el token para el usuario asignado que da acceso al resto de endpoint")
public class AutenticacionController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<UsuarioDTOjwt> AutenticarUsuario (@RequestBody @Valid UsuarioDTOlogin usuarioDTOlogin){
		
		Authentication authToken = new UsernamePasswordAuthenticationToken(
												usuarioDTOlogin.usuario(),
												usuarioDTOlogin.contrasena());
		var usuarioAutenticado = authenticationManager.authenticate(authToken);
		var jwtToken = tokenService.generarToken((Usuario)usuarioAutenticado.getPrincipal());
		return ResponseEntity.ok(new UsuarioDTOjwt(jwtToken));
		
	}

}
