package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.ServicioPrestado;

public interface RepositorioServicioPrestado {

    Long crear(ServicioPrestado servicioPrestado);

    void actualizar(ServicioPrestado servicioPrestado);

    void eliminar(Long id);

    boolean existe(String identificacionMaquina);

    boolean existePorId(Long id);

}
