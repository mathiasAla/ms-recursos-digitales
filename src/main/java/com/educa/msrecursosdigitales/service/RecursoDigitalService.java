package com.educa.msrecursosdigitales.service;

import com.educa.msrecursosdigitales.exception.RecursoNoEncontradoException;
import com.educa.msrecursosdigitales.model.RecursoDigital;
import com.educa.msrecursosdigitales.model.TipoRecurso;
import com.educa.msrecursosdigitales.repository.RecursoDigitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecursoDigitalService {

    private final RecursoDigitalRepository recursoRepository;

    public RecursoDigitalService(RecursoDigitalRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<RecursoDigital> listar() {
        return recursoRepository.findAll();
    }

    public RecursoDigital buscarPorId(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Recurso digital no encontrado con id " + id));
    }

    public List<RecursoDigital> buscar(String texto) {
        return recursoRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(texto, texto);
    }

    public List<RecursoDigital> listarPorTipo(TipoRecurso tipo) {
        return recursoRepository.findByTipo(tipo);
    }

    @Transactional
    public RecursoDigital crear(RecursoDigital recurso) {
        recurso.setId(null);
        recurso.setDescargas(0);
        return recursoRepository.save(recurso);
    }

    @Transactional
    public RecursoDigital actualizar(Long id, RecursoDigital datos) {
        RecursoDigital existente = buscarPorId(id);
        existente.setTitulo(datos.getTitulo());
        existente.setAutor(datos.getAutor());
        existente.setTipo(datos.getTipo());
        existente.setFormato(datos.getFormato());
        existente.setUrlArchivo(datos.getUrlArchivo());
        return recursoRepository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        recursoRepository.delete(buscarPorId(id));
    }

    
    @Transactional
    public RecursoDigital registrarDescarga(Long id) {
        RecursoDigital recurso = buscarPorId(id);
        recurso.setDescargas(recurso.getDescargas() + 1);
        return recursoRepository.save(recurso);
    }
}