package com.educa.msrecursosdigitales.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recursos")
public class RecursoDigitalController {

    @GetMapping
    public String listarRecursos() {
        return "Lista de recursos digitales disponibles";
    }

    @GetMapping("/{id}/visualizar")
    public String visualizar(@PathVariable Long id) {
        return "Visualizando recurso " + id;
    }

    @GetMapping("/{id}/descargar")
    public String descargar(@PathVariable Long id) {
        return "Descargando recurso " + id;
    }
}
