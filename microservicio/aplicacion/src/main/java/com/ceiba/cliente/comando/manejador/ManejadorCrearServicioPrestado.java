package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.servicio.ServicioCrearServicioPrestado;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.cliente.comando.ComandoServicioPrestado;
import com.ceiba.cliente.comando.fabrica.FabricaServicioPrestado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearServicioPrestado implements ManejadorComandoRespuesta<ComandoServicioPrestado, ComandoRespuesta<Long>> {

    private final FabricaServicioPrestado fabricaServicioPrestado;
    private final ServicioCrearServicioPrestado servicioCrearServicioPrestado;

    public ManejadorCrearServicioPrestado(FabricaServicioPrestado fabricaServicioPrestado, ServicioCrearServicioPrestado servicioCrearServicioPrestado) {
        this.fabricaServicioPrestado = fabricaServicioPrestado;
        this.servicioCrearServicioPrestado = servicioCrearServicioPrestado;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoServicioPrestado comandoServicioPrestado) {
        ServicioPrestado servicioPrestado = this.fabricaServicioPrestado.crear(comandoServicioPrestado);
        return new ComandoRespuesta<>(this.servicioCrearServicioPrestado.ejecutar(servicioPrestado));
    }


}
