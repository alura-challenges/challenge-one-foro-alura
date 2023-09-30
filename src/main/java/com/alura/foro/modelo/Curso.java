package com.alura.foro.modelo;

import com.alura.foro.dto.CursoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity (name = "Curso")
@Table (name ="Cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String categoria;
	
	public Curso(@Valid CursoDTO cursoDTO) {
		this.nombre=cursoDTO.nombre();
		this.categoria=cursoDTO.categoria();
	}
	
}
