package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoServicioPrestado;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarServicioPrestado;
import com.ceiba.cliente.comando.manejador.ManejadorCrearServicioPrestado;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarServicioPrestado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicio")
@Api(tags = {"Controlador para los servicios prestados de Maquinas Agricolas TractoMaquinas"})
public class ComandoControladorServicioPrestado {

    private final ManejadorCrearServicioPrestado manejadorCrearServicioPrestado;
    private final ManejadorEliminarServicioPrestado manejadorEliminarServicioPrestado;
    private final ManejadorActualizarServicioPrestado manejadorActualizarServicioPrestado;

    @Autowired
    public ComandoControladorServicioPrestado(ManejadorCrearServicioPrestado manejadorCrearServicioPrestado,
                                              ManejadorEliminarServicioPrestado manejadorEliminarServicioPrestado,
                                              ManejadorActualizarServicioPrestado manejadorActualizarServicioPrestado) {
        this.manejadorCrearServicioPrestado = manejadorCrearServicioPrestado;
        this.manejadorEliminarServicioPrestado = manejadorEliminarServicioPrestado;
        this.manejadorActualizarServicioPrestado = manejadorActualizarServicioPrestado;
    }

    @PostMapping
    @ApiOperation("Crear Servicio ")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoServicioPrestado comandoServicioPrestado) {
        return manejadorCrearServicioPrestado.ejecutar(comandoServicioPrestado);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Servicio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarServicioPrestado.ejecutar(id);
    }


    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Servicio")
    public void actualizar(@RequestBody ComandoServicioPrestado comandoServicioPrestado, @PathVariable Long id) {
        comandoServicioPrestado.setId(id);
        manejadorActualizarServicioPrestado.ejecutar(comandoServicioPrestado);
    }
}
