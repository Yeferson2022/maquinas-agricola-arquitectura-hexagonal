package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoMaquina;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarMaquinaTrabajo;
import com.ceiba.cliente.comando.manejador.ManejadorCrearMaquinaTrabajo;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarMaquinaTrabajo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maquinas")
@Api(tags = {"Controlador para los servicios prestados de Maquinas Agricolas TractoMaquinas"})
public class ComandoControladorMaquinaTrabajo {

    private final ManejadorCrearMaquinaTrabajo manejadorCrearMaquinaTrabajo;
    private final ManejadorEliminarMaquinaTrabajo manejadorEliminarMaquinaTrabajo;
    private final ManejadorActualizarMaquinaTrabajo manejadorActualizarMaquinaTrabajo;

    @Autowired
    public ComandoControladorMaquinaTrabajo(ManejadorCrearMaquinaTrabajo manejadorCrearMaquinaTrabajo,
                                            ManejadorEliminarMaquinaTrabajo manejadorEliminarMaquinaTrabajo,
                                            ManejadorActualizarMaquinaTrabajo manejadorActualizarMaquinaTrabajo) {
        this.manejadorCrearMaquinaTrabajo = manejadorCrearMaquinaTrabajo;
        this.manejadorEliminarMaquinaTrabajo = manejadorEliminarMaquinaTrabajo;
        this.manejadorActualizarMaquinaTrabajo = manejadorActualizarMaquinaTrabajo;
    }

    @PostMapping
    @ApiOperation("Crear Servicio ")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMaquina comandoMaquina) {
        return manejadorCrearMaquinaTrabajo.ejecutar(comandoMaquina);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Servicio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarMaquinaTrabajo.ejecutar(id);
    }


    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Servicio")
    public void actualizar(@RequestBody ComandoMaquina comandoMaquina, @PathVariable Long id) {
        comandoMaquina.setId(id);
        manejadorActualizarMaquinaTrabajo.ejecutar(comandoMaquina);
    }
}
