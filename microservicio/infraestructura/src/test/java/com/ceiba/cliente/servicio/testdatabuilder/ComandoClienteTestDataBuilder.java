package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.util.UUID;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String identificacion;
    private String vereda;

    public ComandoClienteTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        identificacion = "1234";
        vereda = "oroque";
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id, nombre, identificacion, vereda);
    }
}
