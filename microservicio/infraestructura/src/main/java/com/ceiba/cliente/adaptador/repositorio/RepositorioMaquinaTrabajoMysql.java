package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMaquinaTrabajoMysql implements RepositorioMaquina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "maquinaTrabajo", value = "crearMaquina")
    private static String sqlCrearMaquina;

    @SqlStatement(namespace = "maquinaTrabajo", value = "actualizarMaquina")
    private static String sqlActualizarMaquina;

    @SqlStatement(namespace = "maquinaTrabajo", value = "eliminarMaquina")
    private static String sqlEliminarMaquina;

    @SqlStatement(namespace = "maquinaTrabajo", value = "existeMaquina")
    private static String sqlExisteMaquina;

    @SqlStatement(namespace = "maquinaTrabajo", value = "existePorIdMaquina")
    private static String sqlExistePorIdMaquina;

    public RepositorioMaquinaTrabajoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(MaquinaTrabajo maquinaTrabajo) {
        return this.customNamedParameterJdbcTemplate.crear(maquinaTrabajo, sqlCrearMaquina);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarMaquina, paramSource);
    }

    @Override
    public boolean existe(String identificacionMaquina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacionMaquina", identificacionMaquina);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteMaquina, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(MaquinaTrabajo maquinaTrabajo) {
        this.customNamedParameterJdbcTemplate.actualizar(maquinaTrabajo, sqlActualizarMaquina);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdMaquina, paramSource, Boolean.class);
    }
}
