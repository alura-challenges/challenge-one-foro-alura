package com.alura.foro.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.dto.TopicoDTOupdate;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity (name = "Topico")
@Table (name ="Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	@Column(name = "fechacreacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico estado = StatusTopico.NO_RESPONDIDO;
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario autor;
	@ManyToOne
	@JoinColumn(name = "id_Curso")
	private Curso curso;
	@ManyToMany
	@JoinTable (
			name = "Topico_Respuesta",
			joinColumns ={ @JoinColumn (name = "id_Topico") }, 
			        inverseJoinColumns = { @JoinColumn(name = "id_Respuesta") }
			)
	private List<Respuesta> respuestas = new ArrayList<>();
	
	public Topico(TopicoDTO topicoDTO,Usuario usuario, Curso curso) {	
		this.titulo=topicoDTO.titulo();
		this.mensaje=topicoDTO.mensaje();
		this.autor=usuario;
		this.curso=curso;	
	}

	public void actualizarDatos(TopicoDTOupdate topicoDTOupdate, Curso cursoUpdate) {
		if (topicoDTOupdate.titulo()!=null&&!topicoDTOupdate.titulo().isBlank()) {
			this.titulo=topicoDTOupdate.titulo();
		}
		
		if(topicoDTOupdate.mensaje()!=null&&!topicoDTOupdate.mensaje().isBlank()) {
			this.mensaje=topicoDTOupdate.mensaje();
		}
		
		if (curso!=null) {
			this.curso=cursoUpdate;
		}
		
	}
	
	
	
/*
	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
*/
}
