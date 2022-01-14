package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarServicioPrestado {

    private static final String EL_TRABAJO_DE_LA_MAQUINA_NO_EXISTE_EN_EL_SISTEMA = "El trabajo de la maquina no existe en el sistema";

    private final RepositorioServicioPrestado repositorioServicioPrestado;

    public ServicioActualizarServicioPrestado(RepositorioServicioPrestado repositorioServicioPrestado) {
        this.repositorioServicioPrestado = repositorioServicioPrestado;
    }

    public void ejecutar(ServicioPrestado servicioPrestado) {
        validarExistenciaPrevia(servicioPrestado);
        this.repositorioServicioPrestado.actualizar(servicioPrestado);
    }

    private void validarExistenciaPrevia(ServicioPrestado servicioPrestado) {
        boolean existe = this.repositorioServicioPrestado.existePorId(servicioPrestado.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_TRABAJO_DE_LA_MAQUINA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
