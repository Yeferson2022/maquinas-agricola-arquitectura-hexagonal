package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoServicioPrestado;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicioPrestado {

    @Autowired
    RepositorioCliente repositorioCliente;

    public ServicioPrestado crear(ComandoServicioPrestado comandoServicioPrestado) {
        return new ServicioPrestado(
                comandoServicioPrestado.getId(),
                repositorioCliente.obtenerId(comandoServicioPrestado.getIdCliente()),
                comandoServicioPrestado.getIdentificacionMaquina(),
                comandoServicioPrestado.getTipoTrabajo(),
                comandoServicioPrestado.getCantidadHorasCargas(),
                comandoServicioPrestado.getTotal(),
                comandoServicioPrestado.getFechaUltimoMantenimiento(),
                comandoServicioPrestado.getFechaProximoMantenimiento()
        );
    }

}
