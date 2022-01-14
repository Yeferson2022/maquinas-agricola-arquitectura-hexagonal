package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarServicioPrestado;
import com.ceiba.cliente.consulta.ManejadorListarServicioPrestadoCliente;
import com.ceiba.cliente.consulta.ManejadorListarServicioPrestadoIdentificacion;
import com.ceiba.cliente.modelo.dto.DtoServicioPrestado;
import com.ceiba.cliente.modelo.dto.DtoServicioPrestadoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicio")
@Api(tags = {"Controlador para consultar los servicios prestados de Maquinas Agricolas TractoMaquinas"})
public class ConsultaControladorServicioPrestado {

    private final ManejadorListarServicioPrestado manejadorListarServicioPrestado;
    private final ManejadorListarServicioPrestadoIdentificacion manejadorListarServicioPrestadoIdentificacion;
    private final ManejadorListarServicioPrestadoCliente manejadorListarServicioPrestadoCliente;

    public ConsultaControladorServicioPrestado(ManejadorListarServicioPrestado manejadorListarServicioPrestado,
                                               ManejadorListarServicioPrestadoCliente manejadorListarServicioPrestadoCliente,
                                               ManejadorListarServicioPrestadoIdentificacion manejadorListarServicioPrestadoIdentificacion){

        this.manejadorListarServicioPrestado = manejadorListarServicioPrestado;
        this.manejadorListarServicioPrestadoCliente = manejadorListarServicioPrestadoCliente;
        this.manejadorListarServicioPrestadoIdentificacion = manejadorListarServicioPrestadoIdentificacion;

    }

    @GetMapping(value = "/{identificacionMaquina}")
    @ApiOperation("Consultar Servicio Prestado Por Maquina Agricola")
    public List<DtoServicioPrestado> listarIdentificacionMaquina(@PathVariable String identificacionMaquina) {
        return this.manejadorListarServicioPrestadoIdentificacion.ejecutar(identificacionMaquina);
    }

    @GetMapping(value = "Cliente/{identificacion}")
    @ApiOperation("Consultar Servicio Prestado A Un Cliente En Especifico")
    public List<DtoServicioPrestadoCliente> listarIdentificacionMaquinaCliente(@PathVariable String identificacion) {
        return this.manejadorListarServicioPrestadoCliente.ejecutar(identificacion);
    }

    @GetMapping
    @ApiOperation("Listar Todos Los Servicios Prestados")
    public List<DtoServicioPrestado> listar() {
        return this.manejadorListarServicioPrestado.ejecutar();
    }

}
