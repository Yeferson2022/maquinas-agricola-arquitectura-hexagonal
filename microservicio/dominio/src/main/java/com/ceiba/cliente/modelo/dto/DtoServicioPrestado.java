package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoServicioPrestado {

    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private LocalDate fechaUltimoMantenimiento;
    private LocalDate fechaProximoMantenimiento;
}
