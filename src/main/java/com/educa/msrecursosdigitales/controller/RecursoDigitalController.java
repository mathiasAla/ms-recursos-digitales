package com.educa.msrecursosdigitales.controller;

import com.educa.msrecursosdigitales.model.RecursoDigital;
import com.educa.msrecursosdigitales.model.TipoRecurso;
import com.educa.msrecursosdigitales.service.RecursoDigitalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoDigitalController {

    private final RecursoDigitalService recursoService;

    public RecursoDigitalController(RecursoDigitalService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public List<RecursoDigital> listar() {
        return recursoService.listar();
    }

    @GetMapping("/{id}")
    public RecursoDigital obtener(@PathVariable Long id) {
        return recursoService.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<RecursoDigital> buscar(@RequestParam String texto) {
        return recursoService.buscar(texto);
    }

    @GetMapping("/tipo/{tipo}")
    public List<RecursoDigital> listarPorTipo(@PathVariable TipoRecurso tipo) {
        return recursoService.listarPorTipo(tipo);
    }

    @PostMapping
    public ResponseEntity<RecursoDigital> crear(@Valid @RequestBody RecursoDigital recurso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recursoService.crear(recurso));
    }

    @PutMapping("/{id}")
    public RecursoDigital actualizar(@PathVariable Long id, @Valid @RequestBody RecursoDigital recurso) {
        return recursoService.actualizar(id, recurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        recursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    
    @PostMapping("/{id}/descargar")
    public RecursoDigital descargar(@PathVariable Long id) {
        return recursoService.registrarDescarga(id);
    }
}