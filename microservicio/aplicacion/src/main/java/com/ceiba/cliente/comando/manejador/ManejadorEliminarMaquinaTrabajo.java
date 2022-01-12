package com.ceiba.cliente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.servicio.ServicioEliminarMaquinaTrabajo;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarMaquinaTrabajo implements ManejadorComando<Long> {

    private final ServicioEliminarMaquinaTrabajo servicioEliminarMaquinaTrabajo;

    public ManejadorEliminarMaquinaTrabajo(ServicioEliminarMaquinaTrabajo servicioEliminarMaquinaTrabajo) {
        this.servicioEliminarMaquinaTrabajo = servicioEliminarMaquinaTrabajo;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarMaquinaTrabajo.ejecutar(idUsuario);
    }
}
