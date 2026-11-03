package com.cristofer.gasolineras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristofer.gasolineras.model.Gasolinera;

public interface GasolineraRepository  extends JpaRepository<Gasolinera, Long> {
    
}
