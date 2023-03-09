package com.ceiba.servicioPrestado.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.cliente.servicio.ServicioEliminarServicioPrestado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarServicioPrestadoTest {

    @Test
    @DisplayName("Deberia eliminar el trabajo llamando al repositorio")
    void deberiaEliminarElclienteLlamandoAlRepositorio() {
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        ServicioEliminarServicioPrestado servicioEliminarServicioPrestado = new ServicioEliminarServicioPrestado(repositorioServicioPrestado);

        servicioEliminarServicioPrestado.ejecutar(1l);

        Mockito.verify(repositorioServicioPrestado, Mockito.times(1)).eliminar(1l);

    }

}
