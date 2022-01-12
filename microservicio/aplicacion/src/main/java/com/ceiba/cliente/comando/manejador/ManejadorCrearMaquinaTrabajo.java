package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.cliente.comando.ComandoMaquina;
import com.ceiba.cliente.comando.fabrica.FabricaMaquinaTrabajo;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.servicio.ServicioCrearMaquinaTrabajo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMaquinaTrabajo implements ManejadorComandoRespuesta<ComandoMaquina, ComandoRespuesta<Long>> {

    private final FabricaMaquinaTrabajo fabricaMaquinaTrabajo;
    private final ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo;

    public ManejadorCrearMaquinaTrabajo(FabricaMaquinaTrabajo fabricaMaquinaTrabajo, ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo) {
        this.fabricaMaquinaTrabajo = fabricaMaquinaTrabajo;
        this.servicioCrearMaquinaTrabajo = servicioCrearMaquinaTrabajo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMaquina comandoMaquina) {
        MaquinaTrabajo maquinaTrabajo = this.fabricaMaquinaTrabajo.crear(comandoMaquina);
        return new ComandoRespuesta<>(this.servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo));
    }


}
