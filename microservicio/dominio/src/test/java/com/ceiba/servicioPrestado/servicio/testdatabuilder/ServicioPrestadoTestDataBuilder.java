package com.ceiba.servicioPrestado.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.ServicioPrestado;

import java.time.LocalDate;

public class ServicioPrestadoTestDataBuilder {

    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private LocalDate fechaUltimoMantenimiento;
    private LocalDate fechaProximoMantenimiento;

    public ServicioPrestadoTestDataBuilder() {

        idCliente = 1l;
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

    public ServicioPrestadoTestDataBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public ServicioPrestadoTestDataBuilder conIdentificacion(String identificacionMaquina) {
        this.identificacionMaquina = identificacionMaquina;
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
        return new ServicioPrestado(id, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, fechaUltimoMantenimiento, fechaProximoMantenimiento);
    }
}
