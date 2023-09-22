package com.alura.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alura.foro.dto.CursoDTO;
import com.alura.foro.modelo.Curso;
import com.alura.foro.repository.CursoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@PostMapping
	public void registrarTopico(@RequestBody @Valid CursoDTO curso) {
		cursoRepository.save(new Curso(curso));
	}
	
	@GetMapping
	public List<Curso> ListarCursos (){
		return cursoRepository.findAll();
	}
	

}
