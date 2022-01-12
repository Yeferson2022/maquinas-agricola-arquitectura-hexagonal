package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarMaquinaTrabajo {

    private static final String EL_TRABAJO_DE_LA_MAQUINA_NO_EXISTE_EN_EL_SISTEMA = "El trabajo de la maquina no existe en el sistema";

    private final RepositorioMaquina repositorioMaquina;

    public ServicioActualizarMaquinaTrabajo(RepositorioMaquina repositorioMaquina) {
        this.repositorioMaquina = repositorioMaquina;
    }

    public void ejecutar(MaquinaTrabajo maquinaTrabajo) {
        validarExistenciaPrevia(maquinaTrabajo);
        this.repositorioMaquina.actualizar(maquinaTrabajo);
    }

    private void validarExistenciaPrevia(MaquinaTrabajo maquinaTrabajo) {
        boolean existe = this.repositorioMaquina.existePorId(maquinaTrabajo.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_TRABAJO_DE_LA_MAQUINA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
