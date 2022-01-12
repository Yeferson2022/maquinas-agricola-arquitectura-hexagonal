package com.ceiba.maquinaTrabajo.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import com.ceiba.cliente.servicio.ServicioEliminarMaquinaTrabajo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarMaquinaTrabajoTest {

    @Test
    @DisplayName("Deberia eliminar el trabajo llamando al repositorio")
    void deberiaEliminarElclienteLlamandoAlRepositorio() {
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        ServicioEliminarMaquinaTrabajo servicioEliminarMaquinaTrabajo = new ServicioEliminarMaquinaTrabajo(repositorioMaquina);

        servicioEliminarMaquinaTrabajo.ejecutar(1l);

        Mockito.verify(repositorioMaquina, Mockito.times(1)).eliminar(1l);

    }

}
