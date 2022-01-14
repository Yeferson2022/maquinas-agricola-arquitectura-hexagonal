package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoServicioPrestadoCliente;
import com.ceiba.cliente.puerto.dao.DaoServicioPrestado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicioPrestadoCliente {

    private final DaoServicioPrestado daoServicioPrestado;

    public ManejadorListarServicioPrestadoCliente(DaoServicioPrestado daoServicioPrestado) {
        this.daoServicioPrestado = daoServicioPrestado;

    }

    public List<DtoServicioPrestadoCliente> ejecutar(String identificacion) {
        return this.daoServicioPrestado.listarIdentificacionMaquinaCliente(identificacion);
    }
}
