package com.ceiba.maquinaTrabajo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.maquinaTrabajo.servicio.testdatabuilder.MaquinaTrabajoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaquinaTrabajoTest {

    @Test
    @DisplayName("Deberia crear correctamente el Trabajo de la Maquina")
    void deberiaCrearCorrectamenteElTrabajo() {

        //act
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, maquinaTrabajo.getId());
        assertEquals(1, maquinaTrabajo.getIdCliente());
        assertEquals("Ford 6600", maquinaTrabajo.getIdentificacionMaquina());
        assertEquals(1, maquinaTrabajo.getTipoTrabajo());
        assertEquals(11, maquinaTrabajo.getCantidadHorasCargas());
    }


    @Test
    void deberiaFallarSinCantidadHorasCargas() {

        //Arrange
        MaquinaTrabajoTestDataBuilder maquinaTrabajoTestDataBuilder = new MaquinaTrabajoTestDataBuilder().conCantidadHorasCargas(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    maquinaTrabajoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad");
    }

}
