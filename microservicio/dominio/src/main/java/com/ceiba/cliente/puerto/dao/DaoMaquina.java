package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajo;
import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajoCliente;

import java.util.List;

public interface DaoMaquina {

    List<DtoMaquinaTrabajo> listar();

    List<DtoMaquinaTrabajo> listarIdentificacionMaquina(String identificacionMaquina);

    List<DtoMaquinaTrabajoCliente> listarIdentificacionMaquinaCliente(String identificacion);

}
