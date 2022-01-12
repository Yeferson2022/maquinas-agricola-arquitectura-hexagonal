package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import com.ceiba.cliente.servicio.ServicioActualizarMaquinaTrabajo;
import com.ceiba.cliente.servicio.ServicioCrearMaquinaTrabajo;
import com.ceiba.cliente.servicio.ServicioEliminarMaquinaTrabajo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioMaquina {

    @Bean
    public ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo(RepositorioMaquina repositorioMaquina) {
        return new ServicioCrearMaquinaTrabajo(repositorioMaquina);
    }

    @Bean
    public ServicioEliminarMaquinaTrabajo servicioEliminarMaquinaTrabajo(RepositorioMaquina repositorioMaquina) {
        return new ServicioEliminarMaquinaTrabajo(repositorioMaquina);
    }

    @Bean
    public ServicioActualizarMaquinaTrabajo servicioActualizarMaquinaTrabajo(RepositorioMaquina repositorioMaquina) {
        return new ServicioActualizarMaquinaTrabajo(repositorioMaquina);
    }

}
