package com.ceiba.maquinaTrabajo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.controlador.ConsultaControladorCliente;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorCliente.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorMaquinaTrabajoTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar servicios prestados")
    void deberiaListarServicios() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/maquinas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idCliente", is(1)))
                .andExpect(jsonPath("$[0].identificacionMaquina", is("Ford 5000")))
                .andExpect(jsonPath("$[0].tipoTrabajo", is(1)))
                .andExpect(jsonPath("$[0].cantidadHorasCargas", is(11)))
                .andExpect(jsonPath("$[0].total", is(440000)))
                .andExpect(jsonPath("$[0].fechaProximoMantenimiento", is("01/04/20222")));

    }

    @Test
    @DisplayName("Deberia listar servicios prestados por la identificacion de la maquina")
    void deberiaListarServiciosIdentificacion() throws Exception {
        // arrange
        String identificacionMaquina = "Ford 5000";
        // act - assert
        mocMvc.perform(get("/maquinas/{identificacionMaquina}", identificacionMaquina)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idCliente", is(1)))
                .andExpect(jsonPath("$[0].identificacionMaquina", is("Ford 5000")))
                .andExpect(jsonPath("$[0].tipoTrabajo", is(1)))
                .andExpect(jsonPath("$[0].cantidadHorasCargas", is(11)))
                .andExpect(jsonPath("$[0].total", is(440000)))
                .andExpect(jsonPath("$[0].fechaProximoMantenimiento", is("01/04/20222")));

    }
}
