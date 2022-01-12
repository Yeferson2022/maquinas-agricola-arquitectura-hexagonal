package com.ceiba.cliente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final ServicioEliminarCliente servicioEliminarCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarCliente.ejecutar(idUsuario);
    }
}
