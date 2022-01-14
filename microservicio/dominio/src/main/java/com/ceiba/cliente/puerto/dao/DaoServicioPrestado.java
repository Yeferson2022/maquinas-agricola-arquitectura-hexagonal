package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoServicioPrestado;
import com.ceiba.cliente.modelo.dto.DtoServicioPrestadoCliente;

import java.util.List;

public interface DaoServicioPrestado {

    List<DtoServicioPrestado> listar();

    List<DtoServicioPrestado> listarIdentificacionMaquina(String identificacionMaquina);

    List<DtoServicioPrestadoCliente> listarIdentificacionMaquinaCliente(String identificacion);

}
