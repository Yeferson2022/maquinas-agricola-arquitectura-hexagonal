package com.ceiba.servicioPrestado.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoServicioPrestado;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoMaquinaTrabajoTestDataBuilder {

    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private LocalDate fechaUltimoMantenimiento;
    private LocalDate fechaProximoMantenimiento;

    public ComandoMaquinaTrabajoTestDataBuilder() {
        idCliente = 1l;
        identificacionMaquina = UUID.randomUUID().toString();
        tipoTrabajo = 1;
        cantidadHorasCargas = 11l;
        total = 440000l;
        fechaUltimoMantenimiento = LocalDate.parse("2022-01-01");
        fechaProximoMantenimiento = LocalDate.parse("2022-03-01");
    }

    public ComandoServicioPrestado build() {
        return new ComandoServicioPrestado(id, idCliente, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, fechaUltimoMantenimiento, fechaProximoMantenimiento);
    }
}
