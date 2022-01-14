package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.comando.ComandoServicioPrestado;
import com.ceiba.cliente.comando.fabrica.FabricaServicioPrestado;
import com.ceiba.cliente.servicio.ServicioActualizarServicioPrestado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarServicioPrestado implements ManejadorComando<ComandoServicioPrestado> {

    private final FabricaServicioPrestado fabricaServicioPrestado;
    private final ServicioActualizarServicioPrestado servicioActualizarServicioPrestado;

    public ManejadorActualizarServicioPrestado(FabricaServicioPrestado fabricaServicioPrestado, ServicioActualizarServicioPrestado servicioActualizarServicioPrestado) {
        this.fabricaServicioPrestado = fabricaServicioPrestado;
        this.servicioActualizarServicioPrestado = servicioActualizarServicioPrestado;
    }

    public void ejecutar(ComandoServicioPrestado comandoServicioPrestado) {
        ServicioPrestado servicioPrestado = this.fabricaServicioPrestado.crear(comandoServicioPrestado);
        this.servicioActualizarServicioPrestado.ejecutar(servicioPrestado);
    }
}
