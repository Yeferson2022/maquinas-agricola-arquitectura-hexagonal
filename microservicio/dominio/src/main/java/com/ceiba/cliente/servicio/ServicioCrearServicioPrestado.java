package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;


public class ServicioCrearServicioPrestado {


    private final RepositorioServicioPrestado repositorioServicioPrestado;

    public ServicioCrearServicioPrestado(RepositorioServicioPrestado repositorioServicioPrestado) {
        this.repositorioServicioPrestado = repositorioServicioPrestado;
    }

    public Long ejecutar(ServicioPrestado servicioPrestado) {
        return this.repositorioServicioPrestado.crear(servicioPrestado);
    }


}
