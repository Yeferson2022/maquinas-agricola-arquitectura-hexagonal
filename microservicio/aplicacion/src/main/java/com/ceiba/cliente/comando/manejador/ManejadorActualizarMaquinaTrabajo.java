package com.ceiba.cliente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.comando.ComandoMaquina;
import com.ceiba.cliente.comando.fabrica.FabricaMaquinaTrabajo;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.servicio.ServicioActualizarMaquinaTrabajo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarMaquinaTrabajo implements ManejadorComando<ComandoMaquina> {

    private final FabricaMaquinaTrabajo fabricaMaquinaTrabajo;
    private final ServicioActualizarMaquinaTrabajo servicioActualizarMaquinaTrabajo;

    public ManejadorActualizarMaquinaTrabajo(FabricaMaquinaTrabajo fabricaMaquinaTrabajo, ServicioActualizarMaquinaTrabajo servicioActualizarMaquinaTrabajo) {
        this.fabricaMaquinaTrabajo = fabricaMaquinaTrabajo;
        this.servicioActualizarMaquinaTrabajo = servicioActualizarMaquinaTrabajo;
    }

    public void ejecutar(ComandoMaquina comandoMaquina) {
        MaquinaTrabajo maquinaTrabajo = this.fabricaMaquinaTrabajo.crear(comandoMaquina);
        this.servicioActualizarMaquinaTrabajo.ejecutar(maquinaTrabajo);
    }
}
