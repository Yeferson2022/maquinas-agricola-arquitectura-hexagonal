package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajoCliente;
import com.ceiba.cliente.puerto.dao.DaoMaquina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMaquinaTrabajoCliente {

    private final DaoMaquina daoMaquina;

    public ManejadorListarMaquinaTrabajoCliente(DaoMaquina daoMaquina) {
        this.daoMaquina = daoMaquina;

    }

    public List<DtoMaquinaTrabajoCliente> ejecutar(String identificacion) {
        return this.daoMaquina.listarIdentificacionMaquinaCliente(identificacion);
    }
}
