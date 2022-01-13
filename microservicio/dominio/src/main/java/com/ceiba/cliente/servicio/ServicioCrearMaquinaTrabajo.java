package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ServicioCrearMaquinaTrabajo {

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
    private final RepositorioMaquina repositorioMaquina;

    public ServicioCrearMaquinaTrabajo(RepositorioMaquina repositorioMaquina) {
        this.repositorioMaquina = repositorioMaquina;
    }

    public Long ejecutar(MaquinaTrabajo maquinaTrabajo) {
        Long total;
        LocalDate date = LocalDate.now();
        String fechaMantenimiento;
        switch (maquinaTrabajo.getTipoTrabajo()) {
            case TIPO_TRABAJO_1:
                total = (maquinaTrabajo.getCantidadHorasCargas() * TOTAL_TIPO_TRABAJO_1);
                maquinaTrabajo.setTotal(total);
                fechaMantenimiento = addDias(date, MANTENIMIENTO_DIAS_TRABAJO_1);
                maquinaTrabajo.setFechaProximoMantenimiento(fechaMantenimiento);
                break;
            case TIPO_TRABAJO_2:
                total = (maquinaTrabajo.getCantidadHorasCargas() * TOTAL_TIPO_TRABAJO_2);
                maquinaTrabajo.setTotal(total);
                fechaMantenimiento = addDias(date, MANTENIMIENTO_DIAS_TRABAJO_2);
                maquinaTrabajo.setFechaProximoMantenimiento(fechaMantenimiento);
                break;
            case TIPO_TRABAJO_3:
                total = (maquinaTrabajo.getCantidadHorasCargas() * TOTAL_TIPO_TRABAJO_3);
                maquinaTrabajo.setTotal(total);
                fechaMantenimiento = addDias(date, MANTENIMIENTO_DIAS_TRABAJO_3);
                maquinaTrabajo.setFechaProximoMantenimiento(fechaMantenimiento);
                break;
            default:
                throw new ExcepcionValorInvalido(TIPO_DE_TRABAJO_NO_PERMITIDO_EN_EL_SISTEMA);
        }
        return this.repositorioMaquina.crear(maquinaTrabajo);
    }

    public String addDias(LocalDate date, int workdays) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateFormat.format(result);
    }

}
