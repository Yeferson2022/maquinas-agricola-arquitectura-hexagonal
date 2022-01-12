package com.ceiba.maquinaTrabajo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoMaquina;
import com.ceiba.cliente.controlador.ComandoControladorMaquinaTrabajo;
import com.ceiba.maquinaTrabajo.servicio.testdatabuilder.ComandoMaquinaTrabajoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorMaquinaTrabajo.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorMaquinaTrabajoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un servicio prestado")
    void deberiaCrearUnServicio() throws Exception {
        // arrange
        ComandoMaquina maquina = new ComandoMaquinaTrabajoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/maquinas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(maquina)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un servicio prestado")
    void deberiaActualizarUnServicio() throws Exception {
        // arrange
        Long id = 1L;
        ComandoMaquina maquina = new ComandoMaquinaTrabajoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/maquinas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(maquina)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un servicio prestado")
    void deberiaEliminarUnServicio() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/maquinas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
