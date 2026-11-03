package com.cristofer.gasolineras.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cristofer.gasolineras.model.Gasolinera;
import com.cristofer.gasolineras.repository.GasolineraRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/gasolineras")
public class GasolineraController {
    private final GasolineraRepository repository;

    public GasolineraController(GasolineraRepository repository) {
        this.repository = repository;
    }

    // GET all
    @GetMapping
    public List<Gasolinera> listarTodas() {
        return repository.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Gasolinera obtenerPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gasolinera no encontrada"));
    }
    
    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gasolinera crear(@RequestBody Gasolinera gasolinera) { 
        return repository.save(gasolinera);
    }
    
    // UPDATE
    @PostMapping("/{id}")
    public Gasolinera actualizar(@PathVariable Long id, @RequestBody Gasolinera gasolineraActualizada) {
        Gasolinera g = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gasolinera no encontrada"));
        g.setRotulo(gasolineraActualizada.getRotulo());
        g.setDireccion(gasolineraActualizada.getDireccion());
        g.setMunicipio(gasolineraActualizada.getMunicipio());
        g.setProvincia(gasolineraActualizada.getProvincia());
        g.setCodigoPostal(gasolineraActualizada.getCodigoPostal());
        g.setLatitud(gasolineraActualizada.getLatitud());
        g.setLongitud(gasolineraActualizada.getLongitud());
        g.setHorario(gasolineraActualizada.getHorario());
        g.setPrecios(gasolineraActualizada.getPrecios());
        return repository.save(g);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gasolinera no encontrada");
        }
        repository.deleteById(id);
    }
}
