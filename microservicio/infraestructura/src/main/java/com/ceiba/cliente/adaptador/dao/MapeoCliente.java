package com.ceiba.cliente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import org.springframework.jdbc.core.RowMapper;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String identificacion = resultSet.getString("identificacion");
        String vereda = resultSet.getString("vereda");

        return new DtoCliente(id,nombre,identificacion,vereda);
    }

}
    