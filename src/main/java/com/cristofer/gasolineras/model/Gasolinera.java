package com.cristofer.gasolineras.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Gasolinera {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rotulo;
    private String direccion;
    private String municipio;
    private String provincia;
    private String codigoPostal;
    private double latitud;
    private double longitud;
    private String horario;

    @ElementCollection 
    private List<PrecioCombustible> precios = new ArrayList<>();
}
