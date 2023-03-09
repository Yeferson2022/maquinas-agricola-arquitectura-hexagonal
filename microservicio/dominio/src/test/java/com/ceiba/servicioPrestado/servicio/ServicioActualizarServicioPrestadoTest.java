package com.ceiba.servicioPrestado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.cliente.servicio.ServicioActualizarServicioPrestado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicioPrestado.servicio.testdatabuilder.ServicioPrestadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarServicioPrestadoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del Servicio")
    void deberiaValidarLaExistenciaPreviaDelServicio() {
        // arrange
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conId(1L).build();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarServicioPrestado servicioActualizarServicioPrestado = new ServicioActualizarServicioPrestado(repositorioServicioPrestado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarServicioPrestado.ejecutar(servicioPrestado), ExcepcionDuplicidad.class, "El trabajo de la maquina no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conId(1L).build();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarServicioPrestado servicioActualizarServicioPrestado = new ServicioActualizarServicioPrestado(repositorioServicioPrestado);
        // act
        servicioActualizarServicioPrestado.ejecutar(servicioPrestado);
        //assert
        Mockito.verify(repositorioServicioPrestado, Mockito.times(1)).actualizar(servicioPrestado);
    }
}
