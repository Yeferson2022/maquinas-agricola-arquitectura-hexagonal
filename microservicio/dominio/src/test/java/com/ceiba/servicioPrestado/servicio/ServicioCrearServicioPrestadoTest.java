package com.ceiba.servicioPrestado.servicio;

import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.cliente.servicio.ServicioCrearServicioPrestado;
import com.ceiba.servicioPrestado.servicio.testdatabuilder.ServicioPrestadoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearServicioPrestadoTest {


    @Test
    @DisplayName("Deberia Crear el Servicio de manera correcta")
    void deberiaCrearElServicioDeManeraCorrecta() {
        // arrange
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().build();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.crear(servicioPrestado)).thenReturn(10L);
        ServicioCrearServicioPrestado servicioCrearServicioPrestado = new ServicioCrearServicioPrestado(repositorioServicioPrestado);
        // act
        Long idCliente = servicioCrearServicioPrestado.ejecutar(servicioPrestado);
        //- assert
        assertEquals(10L, idCliente);
        Mockito.verify(repositorioServicioPrestado, Mockito.times(1)).crear(servicioPrestado);
    }


}
