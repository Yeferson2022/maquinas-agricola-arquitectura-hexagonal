package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajo;
import com.ceiba.cliente.modelo.dto.DtoMaquinaTrabajoCliente;
import com.ceiba.cliente.puerto.dao.DaoMaquina;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMaquinaTrabajoMysql implements DaoMaquina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "maquinaTrabajo", value = "listarMaquina")
    private static String sqlListarMaquina;

    @SqlStatement(namespace = "maquinaTrabajo", value = "listarMaquinaIdentificacion")
    private static String sqlListarMaquinaIdentificacion;

    @SqlStatement(namespace = "maquinaTrabajo", value = "listarMaquinaIdentificacionCliente")
    private static String sqlListarMaquinaIdentificacionCliente;

    public DaoMaquinaTrabajoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMaquinaTrabajo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarMaquina, new MapeoMaquinaTrabajo());
    }

    @Override
    public List<DtoMaquinaTrabajo> listarIdentificacionMaquina(String identificacionMaquina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacionMaquina", identificacionMaquina);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarMaquinaIdentificacion, paramSource, new MapeoMaquinaTrabajo());
    }

    @Override
    public List<DtoMaquinaTrabajoCliente> listarIdentificacionMaquinaCliente(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarMaquinaIdentificacionCliente, paramSource, new MapeoMaquinaTrabajoCliente());
    }

}













