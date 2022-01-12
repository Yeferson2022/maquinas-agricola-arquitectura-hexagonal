package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajo;
import com.ceiba.cliente.puerto.dao.DaoMaquina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMaquinaTrabajoIdentificacion {

    private final DaoMaquina daoMaquina;

    public ManejadorListarMaquinaTrabajoIdentificacion(DaoMaquina daoMaquina) {
        this.daoMaquina = daoMaquina;

    }

    public List<DtoMaquinaTrabajo> ejecutar(String identificacionMaquina) {
        return this.daoMaquina.listarIdentificacionMaquina(identificacionMaquina);
    }
}
