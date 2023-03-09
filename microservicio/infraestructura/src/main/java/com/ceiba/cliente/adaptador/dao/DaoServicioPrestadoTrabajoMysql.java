package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoServicioPrestado;
import com.ceiba.cliente.modelo.dto.DtoServicioPrestadoCliente;
import com.ceiba.cliente.puerto.dao.DaoServicioPrestado;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioPrestadoTrabajoMysql implements DaoServicioPrestado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "servicioPrestado", value = "listarServicioPrestado")
    private static String sqlListarServicioPrestado;

    @SqlStatement(namespace = "servicioPrestado", value = "listarServicioPrestadoIdentificacion")
    private static String sqlListarServicioPrestadoIdentificacion;

    @SqlStatement(namespace = "servicioPrestado", value = "listarServicioPrestadoIdentificacionCliente")
    private static String sqlListarServicioPrestadoIdentificacionCliente;

    public DaoServicioPrestadoTrabajoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicioPrestado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarServicioPrestado, new MapeoServicioPrestado());
    }

    @Override
    public List<DtoServicioPrestado> listarIdentificacionMaquina(String identificacionMaquina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacionMaquina", identificacionMaquina);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarServicioPrestadoIdentificacion, paramSource, new MapeoServicioPrestado());
    }

    @Override
    public List<DtoServicioPrestadoCliente> listarIdentificacionMaquinaCliente(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarServicioPrestadoIdentificacionCliente, paramSource, new MapeoServicioPrestadoCliente());
    }

}













