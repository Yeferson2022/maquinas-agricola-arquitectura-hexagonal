package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoServicioPrestado;
import com.ceiba.cliente.puerto.dao.DaoServicioPrestado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicioPrestado {

    private final DaoServicioPrestado daoServicioPrestado;

    public ManejadorListarServicioPrestado(DaoServicioPrestado daoServicioPrestado) {
        this.daoServicioPrestado = daoServicioPrestado;

    }

    public List<DtoServicioPrestado> ejecutar() {
        return this.daoServicioPrestado.listar();
    }
}
