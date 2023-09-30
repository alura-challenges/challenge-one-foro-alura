package com.alura.foro.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alura.foro.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
    private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//Obetener token.
		var authHeader = request.getHeader("Authorization");
		
		if (authHeader!=null) {
			String token = authHeader.replace("Bearer ", "");
			String nombreUsuario = tokenService.getSubject(token); // Obtener nombre de usuario del token
			
			if (nombreUsuario != null) {
                var usuario = usuarioRepository.findByNombre(nombreUsuario);
                
                var authentication = new UsernamePasswordAuthenticationToken(
                		usuario, 
                		null,
                        usuario.getAuthorities()); 
             // Forzado inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
		}
		
		//Conexcion con los Controllers - siguiente nivel.
		filterChain.doFilter(request, response);
	}

}
