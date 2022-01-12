package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    Long crear(Cliente cliente);

    void actualizar(Cliente cliente);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorId(Long id);

}
