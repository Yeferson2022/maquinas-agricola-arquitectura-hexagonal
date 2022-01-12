package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombreCliente;
    private String identificacion;
    private String vereda;

    public ClienteTestDataBuilder() {
        nombreCliente = "Yeferson";
        identificacion = "1094580";
        vereda = "Bello Valle";
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conVereda(String vereda) {
        this.vereda = vereda;
        return this;
    }

    public ClienteTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public Cliente build() {
        return new Cliente(id, nombreCliente, identificacion, vereda);
    }
}
