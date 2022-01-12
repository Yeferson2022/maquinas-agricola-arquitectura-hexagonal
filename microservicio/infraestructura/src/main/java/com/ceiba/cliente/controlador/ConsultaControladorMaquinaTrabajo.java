package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarMaquinaTrabajo;
import com.ceiba.cliente.consulta.ManejadorListarMaquinaTrabajoCliente;
import com.ceiba.cliente.consulta.ManejadorListarMaquinaTrabajoIdentificacion;
import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajo;
import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maquinas")
@Api(tags = {"Controlador para consultar los servicios prestados de Maquinas Agricolas TractoMaquinas"})
public class ConsultaControladorMaquinaTrabajo {

    private final ManejadorListarMaquinaTrabajo manejadorListarMaquinaTrabajo;
    private final ManejadorListarMaquinaTrabajoIdentificacion manejadorListarMaquinaTrabajoIdentificacion;
    private final ManejadorListarMaquinaTrabajoCliente manejadorListarMaquinaTrabajoCliente;

    public ConsultaControladorMaquinaTrabajo(ManejadorListarMaquinaTrabajo manejadorListarMaquinaTrabajo,
                                             ManejadorListarMaquinaTrabajoCliente manejadorListarMaquinaTrabajoCliente,
                                             ManejadorListarMaquinaTrabajoIdentificacion manejadorListarMaquinaTrabajoIdentificacion){

        this.manejadorListarMaquinaTrabajo = manejadorListarMaquinaTrabajo;
        this.manejadorListarMaquinaTrabajoCliente = manejadorListarMaquinaTrabajoCliente;
        this.manejadorListarMaquinaTrabajoIdentificacion = manejadorListarMaquinaTrabajoIdentificacion;

    }

    @GetMapping(value = "/{identificacionMaquina}")
    @ApiOperation("Consultar Servicio Prestado Por Maquina Agricola")
    public List<DtoMaquinaTrabajo> listarIdentificacionMaquina(@PathVariable String identificacionMaquina) {
        return this.manejadorListarMaquinaTrabajoIdentificacion.ejecutar(identificacionMaquina);
    }

    @GetMapping(value = "Cliente/{identificacion}")
    @ApiOperation("Consultar Servicio Prestado A Un Cliente En Especifico")
    public List<DtoMaquinaTrabajoCliente> listarIdentificacionMaquinaCliente(@PathVariable String identificacion) {
        return this.manejadorListarMaquinaTrabajoCliente.ejecutar(identificacion);
    }

    @GetMapping
    @ApiOperation("Listar Todos Los Servicios Prestados")
    public List<DtoMaquinaTrabajo> listar() {
        return this.manejadorListarMaquinaTrabajo.ejecutar();
    }

}
