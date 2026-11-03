package com.cristofer.gasolineras.model;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class PrecioCombustible {
    private String tipo;
    private BigDecimal precio;
}
