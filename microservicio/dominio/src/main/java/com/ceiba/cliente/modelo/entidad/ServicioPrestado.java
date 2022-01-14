package com.ceiba.cliente.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class ServicioPrestado {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_TRABAJO = "Se debe ingresar el tipo de trabajo";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_HORAS_O_CARGAS = "Se debe ingresar la cantidad de horas o cargas";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_LA_MAQUINA = "Se debe ingresar la identificacion de la maquina";


    private Long id;
    private Cliente cliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private LocalDate fechaUltimoMantenimiento;
    private LocalDate fechaProximoMantenimiento;

    private static final int TIPO_TRABAJO_1 = 1;
    private static final int TIPO_TRABAJO_2 = 2;
    private static final int TIPO_TRABAJO_3 = 3;
    private static final int TOTAL_TIPO_TRABAJO_1 = 40000;
    private static final int TOTAL_TIPO_TRABAJO_2 = 50000;
    private static final int TOTAL_TIPO_TRABAJO_3 = 20000;
    private static final int MANTENIMIENTO_DIAS_TRABAJO_1 = 40;
    private static final int MANTENIMIENTO_DIAS_TRABAJO_2 = 50;
    private static final int MANTENIMIENTO_DIAS_TRABAJO_3 = 60;
    private static final String TIPO_DE_TRABAJO_NO_PERMITIDO_EN_EL_SISTEMA = "El tipo de trabajo no esta permitido en el sistema";

    public ServicioPrestado(Long id, Cliente cliente, String identificacionMaquina, Integer tipoTrabajo, Long cantidadHorasCargas, Long total, LocalDate fechaUltimoMantenimiento, LocalDate fechaProximoMantenimiento) {
        validarObligatorio(identificacionMaquina, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_LA_MAQUINA);
        validarObligatorio(tipoTrabajo, SE_DEBE_INGRESAR_EL_TIPO_DE_TRABAJO);
        validarObligatorio(cantidadHorasCargas, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_HORAS_O_CARGAS);

        this.id = id;
        this.cliente = cliente;
        this.identificacionMaquina = identificacionMaquina;
        this.tipoTrabajo = tipoTrabajo;
        this.cantidadHorasCargas = cantidadHorasCargas;
        this.total = total;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.fechaProximoMantenimiento = fechaProximoMantenimiento;
        calcularTotal();
    }

    public void calcularTotal() {
        LocalDate date = this.getFechaUltimoMantenimiento();
        switch (this.getTipoTrabajo()) {
            case TIPO_TRABAJO_1:
                this.total = (this.getCantidadHorasCargas() * TOTAL_TIPO_TRABAJO_1);
                this.fechaProximoMantenimiento = addDias(date, MANTENIMIENTO_DIAS_TRABAJO_1);
                break;
            case TIPO_TRABAJO_2:
                this.total = (this.getCantidadHorasCargas() * TOTAL_TIPO_TRABAJO_2);
                this.fechaProximoMantenimiento = addDias(date, MANTENIMIENTO_DIAS_TRABAJO_2);
                break;
            case TIPO_TRABAJO_3:
                this.total = (this.getCantidadHorasCargas() * TOTAL_TIPO_TRABAJO_3);
                this.fechaProximoMantenimiento = addDias(date, MANTENIMIENTO_DIAS_TRABAJO_3);
                break;
            default:
                throw new ExcepcionValorInvalido(TIPO_DE_TRABAJO_NO_PERMITIDO_EN_EL_SISTEMA);
        }
    }

    public LocalDate addDias(LocalDate date, int workdays) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    public ServicioPrestado(Long id, String identificacionMaquina, int tipoTrabajo, Long cantidadHorasCargas, Long total, LocalDate fechaUltimoMantenimiento, LocalDate fechaProximoMantenimiento) {
        this.id = id;
        this.identificacionMaquina = identificacionMaquina;
        this.tipoTrabajo = tipoTrabajo;
        this.cantidadHorasCargas = cantidadHorasCargas;
        this.total = total;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.fechaProximoMantenimiento = fechaProximoMantenimiento;
    }
}
