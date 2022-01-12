package com.ceiba.cliente.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class MaquinaTrabajo {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_TRABAJO = "Se debe ingresar el tipo de trabajo";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_HORAS_O_CARGAS = "Se debe ingresar la cantidad de horas o cargas";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_LA_MAQUINA = "Se debe ingresar la identificacion de la maquina";


    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private String fechaUltimoMantenimiento;
    private String fechaProximoMantenimiento;

    public MaquinaTrabajo(Long id, Long idCliente, String identificacionMaquina, Integer tipoTrabajo, Long cantidadHorasCargas, Long total, String fechaUltimoMantenimiento, String fechaProximoMantenimiento) {
        validarObligatorio(identificacionMaquina, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_LA_MAQUINA);
        validarObligatorio(tipoTrabajo, SE_DEBE_INGRESAR_EL_TIPO_DE_TRABAJO);
        validarObligatorio(cantidadHorasCargas, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_HORAS_O_CARGAS);

        this.id = id;
        this.idCliente = idCliente;
        this.identificacionMaquina = identificacionMaquina;
        this.tipoTrabajo = tipoTrabajo;
        this.cantidadHorasCargas = cantidadHorasCargas;
        this.total = total;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.fechaProximoMantenimiento = fechaProximoMantenimiento;
    }
}
