package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;

public class ServicioEliminarServicioPrestado {

    private final RepositorioServicioPrestado repositorioServicioPrestado;

    public ServicioEliminarServicioPrestado(RepositorioServicioPrestado repositorioServicioPrestado) {
        this.repositorioServicioPrestado = repositorioServicioPrestado;
    }

    public void ejecutar(Long id) {
        this.repositorioServicioPrestado.eliminar(id);
    }
}
