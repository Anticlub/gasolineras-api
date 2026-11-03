package com.cristofer.gasolineras.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "El rótulo es obligatorio")
    private String rotulo;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    @NotBlank(message = "El municipio es obligatorio")
    private String municipio;
    @NotBlank(message = "La provincia es obligatoria")
    private String provincia;
    @NotBlank(message = "El código postal es obligatorio")
    private String codigoPostal;
    @NotBlank(message = "La latitud es obligatoria")
    private double latitud;
    @NotBlank(message = "La longitud es obligatoria")
    private double longitud;
    private String horario;

    @Valid 
    @ElementCollection 
    private List<PrecioCombustible> precios = new ArrayList<>();
}
