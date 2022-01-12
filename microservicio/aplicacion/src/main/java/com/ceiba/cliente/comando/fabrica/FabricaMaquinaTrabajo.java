package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoMaquina;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import org.springframework.stereotype.Component;

@Component
public class FabricaMaquinaTrabajo {

    public MaquinaTrabajo crear(ComandoMaquina comandoMaquina) {
        return new MaquinaTrabajo(
                comandoMaquina.getId(),
                comandoMaquina.getIdCliente(),
                comandoMaquina.getIdentificacionMaquina(),
                comandoMaquina.getTipoTrabajo(),
                comandoMaquina.getCantidadHorasCargas(),
                comandoMaquina.getTotal(),
                comandoMaquina.getFechaUltimoMantenimiento(),
                comandoMaquina.getFechaProximoMantenimiento()
        );
    }

}
