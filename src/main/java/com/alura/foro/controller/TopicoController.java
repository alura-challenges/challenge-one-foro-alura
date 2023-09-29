package com.alura.foro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.dto.TopicoDTOget;
import com.alura.foro.dto.TopicoDTOupdate;
import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.repository.CursoRepository;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
@SuppressWarnings("all")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@PostMapping
	@Operation(summary = "Registra un nuevo topico")
	public ResponseEntity<TopicoDTOget> registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		Usuario usuario = usuarioRepository.getReferenceById(topicoDTO.id_autor());
		Curso curso = cursoRepository.getReferenceById(topicoDTO.id_curso());
		Topico topico = new Topico(topicoDTO,usuario,curso);
		
		topico = topicoRepository.save(topico);
		TopicoDTOget topicoDTOget = new TopicoDTOget(topico);
		
		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(topicoDTOget);
	}
	
	@GetMapping
	@Operation(summary = "Obtiene el listado para los topicos")
	public ResponseEntity<List<TopicoDTOget>> ListadoTopicos () {
		return ResponseEntity.ok(topicoRepository.findAll().stream().map(TopicoDTOget::new).toList());
	}
	
	@GetMapping ("/{id}")
	@Operation(summary = "Obtiene los detalles para un topico con el ID indicado")
	public ResponseEntity<TopicoDTOget> ConsultarUsuarioPorId(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		TopicoDTOget topicoDTOget = new TopicoDTOget(topico);
		return ResponseEntity.ok(topicoDTOget);
	}
	
	@PutMapping
    @Transactional
    @Operation(summary = "Actualiza las informaciones para un topico")
    public ResponseEntity<TopicoDTOget> actualizarTopico(@RequestBody @Valid TopicoDTOupdate topicoDTOupdate) {

        Topico topico = topicoRepository.getReferenceById(topicoDTOupdate.id());
        Usuario usuario = usuarioRepository.getReferenceById(topicoDTOupdate.id_autor());
        Curso curso;
        
        if(topico.getAutor().getId()!=usuario.getId()) {
			throw new RuntimeException("The user request is not the topic ownwer, the topic can not be updated");
		}
        
        if (topicoDTOupdate.id_curso()!=null) {
        	curso = cursoRepository.getReferenceById(topicoDTOupdate.id_curso());
        } else {curso = null;}

        topico.actualizarDatos(topicoDTOupdate,curso);
        TopicoDTOget topicoDTOget = new TopicoDTOget(topico);
        return ResponseEntity.ok(topicoDTOget);
    }
	
	
	@DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina complentamente de la BD un topico con el ID indicado")
    public ResponseEntity<Object> eliminarTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topicoRepository.delete(topico);
		return ResponseEntity.noContent().build();
	}

}
