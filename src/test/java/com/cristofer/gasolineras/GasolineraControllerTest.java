package com.cristofer.gasolineras;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GasolineraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void crearGasolineraValida_devuelve201() throws Exception {
        String json = """
            {
              "rotulo": "Repsol",
              "municipio": "Madrid",
              "precios": [ { "tipo": "Gasolina 95", "precio": 1.529 } ]
            }
            """;

        mockMvc.perform(post("/gasolineras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.rotulo").value("Repsol"));
    }

    @Test
    void crearGasolineraSinRotulo_devuelve400() throws Exception {
        String json = """
            { "municipio": "Madrid" }
            """;

        mockMvc.perform(post("/gasolineras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isBadRequest());
    }

    @Test
    void listarGasolineras_devuelve200() throws Exception {
        mockMvc.perform(get("/gasolineras"))
            .andExpect(status().isOk());
    }

    @Test
    void obtenerPorIdInexistente_devuelve404() throws Exception {
        mockMvc.perform(get("/gasolineras/99999"))
            .andExpect(status().isNotFound());
    }
}