package com.ceiba.cliente.controlador;

import java.util.List;

import com.ceiba.cliente.consulta.ManejadorListarCliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags={"Controlador para consultar los clientes de Maquinas Agricolas TractoMaquinas"})
public class ConsultaControladorCliente {

    private final ManejadorListarCliente manejadorListarCliente;

    public ConsultaControladorCliente(ManejadorListarCliente manejadorListarCliente) {
        this.manejadorListarCliente = manejadorListarCliente;
    }

    @GetMapping
    @ApiOperation("Listar Clientes")
    public List<DtoCliente> listar() {
        return this.manejadorListarCliente.ejecutar();
    }

}
