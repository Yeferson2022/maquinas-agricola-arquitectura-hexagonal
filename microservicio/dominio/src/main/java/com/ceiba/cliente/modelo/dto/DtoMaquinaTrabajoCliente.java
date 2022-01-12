package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMaquinaTrabajoCliente {
    private Long id;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private String nombre;
    private String identificacion;
    private String vereda;
}
