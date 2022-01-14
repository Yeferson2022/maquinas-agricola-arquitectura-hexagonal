package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoServicioPrestado;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoServicioPrestado implements RowMapper<DtoServicioPrestado>, MapperResult {

    @Override
    public DtoServicioPrestado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idCliente = resultSet.getLong("idCliente");
        String identificacionMaquina = resultSet.getString("identificacionMaquina");
        Integer tipoTrabajo = resultSet.getInt("tipoTrabajo");
        Long cantidadHorasCargas = resultSet.getLong("cantidadHorasCargas");
        Long total = resultSet.getLong("total");
        LocalDate fechaUltimoMantenimiento = extraerLocalDate(resultSet,"fechaUltimoMantenimiento");
        LocalDate fechaProximoMantenimiento = extraerLocalDate(resultSet,"fechaProximoMantenimiento");
        return new DtoServicioPrestado(id, idCliente, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, fechaUltimoMantenimiento, fechaProximoMantenimiento);
    }
}
