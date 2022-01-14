package com.ceiba.cliente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.servicio.ServicioEliminarServicioPrestado;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarServicioPrestado implements ManejadorComando<Long> {

    private final ServicioEliminarServicioPrestado servicioEliminarServicioPrestado;

    public ManejadorEliminarServicioPrestado(ServicioEliminarServicioPrestado servicioEliminarServicioPrestado) {
        this.servicioEliminarServicioPrestado = servicioEliminarServicioPrestado;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarServicioPrestado.ejecutar(idUsuario);
    }
}
