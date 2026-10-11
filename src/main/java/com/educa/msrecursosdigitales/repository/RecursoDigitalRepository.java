package com.educa.msrecursosdigitales.repository;

import com.educa.msrecursosdigitales.model.RecursoDigital;
import com.educa.msrecursosdigitales.model.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoDigitalRepository extends JpaRepository<RecursoDigital, Long> {

    List<RecursoDigital> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);

    List<RecursoDigital> findByTipo(TipoRecurso tipo);
}