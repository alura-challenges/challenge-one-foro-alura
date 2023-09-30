package com.alura.foro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.alura.foro.dto.CursoDTO;
import com.alura.foro.dto.CursoDTOget;
import com.alura.foro.modelo.Curso;
import com.alura.foro.repository.CursoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@PostMapping
	@Operation(summary = "Registra un nuevo curso")
	public ResponseEntity<Curso> registrarCurso(@RequestBody @Valid CursoDTO cursoDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		Curso curso = cursoRepository.save(new Curso(cursoDTO));
		URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).body(curso);
	}
	
	@GetMapping
	@Operation(summary = "Obtiene el listado de cursos")
	public ResponseEntity<List<Curso>> ListarCursos (){
		return ResponseEntity.ok(cursoRepository.findAll());
	}
	
	@GetMapping ("/{id}")
	@Operation(summary = "Obtener informacion de un curso con el ID indicado")
	public CursoDTOget ConsultarCursoPorId(@PathVariable Long id) {
			Curso curso = cursoRepository.getReferenceById(id);
			CursoDTOget cursoDTOget = new CursoDTOget(curso);
			return cursoDTOget;
		}
	
	

}
