package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.infraestructura.jdbc.sqlstatement.StatementException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.time.LocalDate;

@Repository
public class RepositorioServicioPrestadoTrabajoMysql implements RepositorioServicioPrestado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "servicioPrestado", value = "crearServicioPrestado")
    private static String sqlCrearServicioPrestado;

    @SqlStatement(namespace = "servicioPrestado", value = "actualizarServicioPrestado")
    private static String sqlActualizarServicioPrestado;

    @SqlStatement(namespace = "servicioPrestado", value = "eliminarServicioPrestado")
    private static String sqlEliminarServicioPrestado;

    @SqlStatement(namespace = "servicioPrestado", value = "existeServicioPrestado")
    private static String sqlExisteServicioPrestado;

    @SqlStatement(namespace = "servicioPrestado", value = "existePorIdServicioPrestado")
    private static String sqlExistePorIdServicioPrestado;

    public RepositorioServicioPrestadoTrabajoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(ServicioPrestado servicioPrestado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", servicioPrestado.getCliente().getId());
        paramSource.addValue("identificacionMaquina", servicioPrestado.getIdentificacionMaquina());
        paramSource.addValue("tipoTrabajo", servicioPrestado.getTipoTrabajo());
        paramSource.addValue("cantidadHorasCargas", servicioPrestado.getCantidadHorasCargas());
        paramSource.addValue("total", servicioPrestado.getTotal());
        paramSource.addValue("fechaUltimoMantenimiento", servicioPrestado.getFechaUltimoMantenimiento());
        paramSource.addValue("fechaProximoMantenimiento", servicioPrestado.getFechaProximoMantenimiento());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrearServicioPrestado, paramSource, keyHolder, new String[]{"id"});
        try {
            return keyHolder.getKey().longValue();
        } catch (Exception e) {
            throw new StatementException("No se encontró el id");
        }

    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarServicioPrestado, paramSource);
    }

    @Override
    public boolean existe(String identificacionMaquina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacionMaquina", identificacionMaquina);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteServicioPrestado, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(ServicioPrestado servicioPrestado) {
        this.customNamedParameterJdbcTemplate.actualizar(servicioPrestado, sqlActualizarServicioPrestado);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdServicioPrestado, paramSource, Boolean.class);
    }
}
