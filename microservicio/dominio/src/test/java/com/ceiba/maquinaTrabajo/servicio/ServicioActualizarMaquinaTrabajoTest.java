package com.ceiba.maquinaTrabajo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import com.ceiba.cliente.servicio.ServicioActualizarMaquinaTrabajo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.maquinaTrabajo.servicio.testdatabuilder.MaquinaTrabajoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarMaquinaTrabajoTest {



    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conId(1L).build();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarMaquinaTrabajo servicioActualizarMaquinaTrabajo = new ServicioActualizarMaquinaTrabajo(repositorioMaquina);
        // act
        servicioActualizarMaquinaTrabajo.ejecutar(maquinaTrabajo);
        //assert
        Mockito.verify(repositorioMaquina, Mockito.times(1)).actualizar(maquinaTrabajo);
    }
}
