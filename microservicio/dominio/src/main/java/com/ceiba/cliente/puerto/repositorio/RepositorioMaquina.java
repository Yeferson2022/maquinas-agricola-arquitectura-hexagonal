package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;

public interface RepositorioMaquina {

    Long crear(MaquinaTrabajo maquinaTrabajo);

    void actualizar(MaquinaTrabajo maquinaTrabajo);

    void eliminar(Long id);

    boolean existe(String identificacionMaquina);

    boolean existePorId(Long id);

}
