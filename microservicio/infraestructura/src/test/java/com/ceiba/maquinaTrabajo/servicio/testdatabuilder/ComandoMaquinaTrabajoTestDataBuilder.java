package com.ceiba.maquinaTrabajo.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.ComandoMaquina;

import java.util.UUID;

public class ComandoMaquinaTrabajoTestDataBuilder {

    private Long id;
    private Long idCliente;
    private String identificacionMaquina;
    private int tipoTrabajo;
    private Long cantidadHorasCargas;
    private Long total;
    private String fechaUltimoMantenimiento;
    private String fechaProximoMantenimiento;

    public ComandoMaquinaTrabajoTestDataBuilder() {
        idCliente= 1l;
        identificacionMaquina = UUID.randomUUID().toString();
        tipoTrabajo = 1;
        cantidadHorasCargas=11l;
        total = 440000l;
        fechaUltimoMantenimiento = "01/01/2022";
        fechaProximoMantenimiento= "01/04/20222";
    }

    public ComandoMaquinaTrabajoTestDataBuilder conIdentificacionMaquina(String identificacionMaquina) {
        this.identificacionMaquina = identificacionMaquina;
        return this;
    }

    public ComandoMaquina build() {
        return new ComandoMaquina(id,idCliente,identificacionMaquina, tipoTrabajo,cantidadHorasCargas,total,fechaUltimoMantenimiento,fechaProximoMantenimiento);
    }
}
