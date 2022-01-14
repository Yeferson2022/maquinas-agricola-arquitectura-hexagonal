package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoClienteServicio implements RowMapper<Cliente>, MapperResult {

    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String identificacion = resultSet.getString("identificacion");
        String vereda = resultSet.getString("vereda");

        return new Cliente(id, nombre, identificacion, vereda);
    }

}
    