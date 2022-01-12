package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMaquinaTrabajo implements RowMapper<DtoMaquinaTrabajo>, MapperResult {

    @Override
    public DtoMaquinaTrabajo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idCliente = resultSet.getLong("idCliente");
        String identificacionMaquina = resultSet.getString("identificacionMaquina");
        Integer tipoTrabajo = resultSet.getInt("tipoTrabajo");
        Long cantidadHorasCargas = resultSet.getLong("cantidadHorasCargas");
        Long total = resultSet.getLong("total");
        String fechaUltimoMantenimiento = resultSet.getString("fechaUltimoMantenimiento");
        String fechaProximoMantenimiento = resultSet.getString("fechaProximoMantenimiento");
        return new DtoMaquinaTrabajo(id, idCliente, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, fechaUltimoMantenimiento, fechaProximoMantenimiento);
    }
}
