package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMaquinaTrabajo {
    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private String fechaUltimoMantenimiento;
    private String fechaProximoMantenimiento;
}
