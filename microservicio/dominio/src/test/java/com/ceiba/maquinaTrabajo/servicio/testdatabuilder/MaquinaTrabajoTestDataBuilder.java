package com.ceiba.maquinaTrabajo.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;

public class MaquinaTrabajoTestDataBuilder {

    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private String fechaUltimoMantenimiento;
    private String fechaProximoMantenimiento;

    public MaquinaTrabajoTestDataBuilder() {
        idCliente = 1l;
        identificacionMaquina = "Ford 6600";
        tipoTrabajo = 1;
        cantidadHorasCargas = 11l;
        total = 440000l;
        fechaUltimoMantenimiento = "01/11/2021";
        fechaProximoMantenimiento = "10/01/2022";

    }

    public MaquinaTrabajoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MaquinaTrabajoTestDataBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public MaquinaTrabajoTestDataBuilder conIdentificacion(String identificacionMaquina) {
        this.identificacionMaquina = identificacionMaquina;
        return this;
    }

    public MaquinaTrabajoTestDataBuilder conTipoTrabajo(Integer tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
        return this;
    }

    public MaquinaTrabajoTestDataBuilder conCantidadHorasCargas(Long cantidadHorasCargas) {
        this.cantidadHorasCargas = cantidadHorasCargas;
        return this;
    }

    public MaquinaTrabajo build() {
        return new MaquinaTrabajo(id, idCliente, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, fechaUltimoMantenimiento, fechaProximoMantenimiento);
    }
}
