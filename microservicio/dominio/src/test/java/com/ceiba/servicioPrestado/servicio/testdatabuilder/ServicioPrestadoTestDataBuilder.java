package com.ceiba.servicioPrestado.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

import java.time.LocalDate;

public class ServicioPrestadoTestDataBuilder {

    private Long id;
    private Cliente cliente;
    private String identificacionMaquina;
    private Integer tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private LocalDate fechaUltimoMantenimiento;
    private LocalDate fechaProximoMantenimiento;

    public ServicioPrestadoTestDataBuilder() {

        cliente = new ClienteTestDataBuilder().build();
        identificacionMaquina = "Ford 6600";
        tipoTrabajo = 1;
        cantidadHorasCargas = 11l;
        total = 440000l;
        fechaUltimoMantenimiento = LocalDate.parse("2021-11-01");
        fechaProximoMantenimiento = LocalDate.parse("2022-01-10");

    }

    public ServicioPrestadoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioPrestadoTestDataBuilder conIdentificacion(String identificacionMaquina) {
        this.identificacionMaquina = identificacionMaquina;
        return this;
    }

    public ServicioPrestadoTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ServicioPrestadoTestDataBuilder conTipoTrabajo(Integer tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
        return this;
    }

    public ServicioPrestadoTestDataBuilder conCantidadHorasCargas(Long cantidadHorasCargas) {
        this.cantidadHorasCargas = cantidadHorasCargas;
        return this;
    }

    public ServicioPrestado build() {
        return new ServicioPrestado(id, cliente, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, fechaUltimoMantenimiento, fechaProximoMantenimiento);
    }
}
