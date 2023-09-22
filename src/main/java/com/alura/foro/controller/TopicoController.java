package com.alura.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.dto.TopicoDTOget;
import com.alura.foro.dto.TopicoDTOupdate;
import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.repository.CursoRepository;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@PostMapping
	public void registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO) {
		Usuario usuario = usuarioRepository.getReferenceById(topicoDTO.id_autor());
		Curso curso = cursoRepository.getReferenceById(topicoDTO.id_curso());
		Topico topico = new Topico(topicoDTO,usuario,curso);
		topicoRepository.save(topico);
	}
	
	@GetMapping
	public List<TopicoDTOget> ListadoUsuarios () {
		return topicoRepository.findAll().stream().map(TopicoDTOget::new).toList();
	}
	
	@GetMapping ("/{id}")
	public TopicoDTOget ConsultarUsuarioPorId(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		TopicoDTOget topicoDTOget = new TopicoDTOget(topico);
		return topicoDTOget;
	}
	
	@PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid TopicoDTOupdate topicoDTOupdate) {

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
    }
	
	@DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topicoRepository.delete(topico);
	}

}
