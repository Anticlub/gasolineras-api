package com.cristofer.gasolineras.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cristofer.gasolineras.model.Gasolinera;
import com.cristofer.gasolineras.repository.GasolineraRepository;

@Service
public class GasolineraService {

    private final GasolineraRepository repository;

    public GasolineraService(GasolineraRepository repository) {
        this.repository = repository;
    }

    public List<Gasolinera> listarTodas() {
        return repository.findAll();
    }

    public Gasolinera obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gasolinera no encontrada"));
    }

    public Gasolinera crear(Gasolinera gasolinera) {
        return repository.save(gasolinera);
    }

    public Gasolinera actualizar(Long id, Gasolinera datos) {
        Gasolinera g = obtenerPorId(id);   // reutiliza el 404 de arriba
        g.setRotulo(datos.getRotulo());
        g.setDireccion(datos.getDireccion());
        g.setMunicipio(datos.getMunicipio());
        g.setProvincia(datos.getProvincia());
        g.setCodigoPostal(datos.getCodigoPostal());
        g.setLatitud(datos.getLatitud());
        g.setLongitud(datos.getLongitud());
        g.setHorario(datos.getHorario());
        g.setPrecios(datos.getPrecios());
        return repository.save(g);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gasolinera no encontrada");
        }
        repository.deleteById(id);
    }
}