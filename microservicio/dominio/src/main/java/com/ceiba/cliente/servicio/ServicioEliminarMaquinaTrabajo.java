package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;

public class ServicioEliminarMaquinaTrabajo {

    private final RepositorioMaquina repositorioMaquina;

    public ServicioEliminarMaquinaTrabajo(RepositorioMaquina repositorioMaquina) {
        this.repositorioMaquina = repositorioMaquina;
    }

    public void ejecutar(Long id) {
        this.repositorioMaquina.eliminar(id);
    }
}
