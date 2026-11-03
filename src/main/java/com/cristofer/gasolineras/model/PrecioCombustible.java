package com.cristofer.gasolineras.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class PrecioCombustible {
    @NotBlank(message = "El tipo de combustible es obligatorio")
    private String tipo;
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser un número positivo")
    private BigDecimal precio;
}
