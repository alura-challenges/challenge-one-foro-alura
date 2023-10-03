package com.alura.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Boolean existsByMensaje(String mensaje);

    Boolean existsByTitulo(String titulo);

    Page<Topico> findAllById(Long id, Pageable paginacion);
}
