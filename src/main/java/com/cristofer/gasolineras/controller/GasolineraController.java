package com.cristofer.gasolineras.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cristofer.gasolineras.model.Gasolinera;
import com.cristofer.gasolineras.service.GasolineraService;

@RestController
@RequestMapping("/gasolineras")
public class GasolineraController {

    private final GasolineraService service;

    public GasolineraController(GasolineraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Gasolinera> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Gasolinera obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gasolinera crear(@Valid @RequestBody Gasolinera gasolinera) {
        return service.crear(gasolinera);
    }

    @PutMapping("/{id}")
    public Gasolinera actualizar(@PathVariable Long id, @Valid @RequestBody Gasolinera datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}