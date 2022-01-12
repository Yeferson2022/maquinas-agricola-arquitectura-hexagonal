package com.ceiba.cliente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajoCliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMaquinaTrabajoCliente implements RowMapper<DtoMaquinaTrabajoCliente>, MapperResult {

    @Override
    public DtoMaquinaTrabajoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String identificacionMaquina = resultSet.getString("identificacionMaquina");
        Integer tipoTrabajo = resultSet.getInt("tipoTrabajo");
        Long cantidadHorasCargas = resultSet.getLong("cantidadHorasCargas");
        Long total = resultSet.getLong("total");
        String nombre = resultSet.getString("nombre");
        String identificacion = resultSet.getString("identificacion");
        String vereda = resultSet.getString("vereda");

        return new DtoMaquinaTrabajoCliente(id, identificacionMaquina, tipoTrabajo, cantidadHorasCargas, total, nombre, identificacion, vereda);
    }
}
