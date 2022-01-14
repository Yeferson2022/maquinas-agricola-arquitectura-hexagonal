package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.cliente.servicio.ServicioActualizarServicioPrestado;
import com.ceiba.cliente.servicio.ServicioCrearServicioPrestado;
import com.ceiba.cliente.servicio.ServicioEliminarServicioPrestado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioMaquina {

    @Bean
    public ServicioCrearServicioPrestado servicioCrearMaquinaTrabajo(RepositorioServicioPrestado repositorioServicioPrestado) {
        return new ServicioCrearServicioPrestado(repositorioServicioPrestado);
    }

    @Bean
    public ServicioEliminarServicioPrestado servicioEliminarMaquinaTrabajo(RepositorioServicioPrestado repositorioServicioPrestado) {
        return new ServicioEliminarServicioPrestado(repositorioServicioPrestado);
    }

    @Bean
    public ServicioActualizarServicioPrestado servicioActualizarMaquinaTrabajo(RepositorioServicioPrestado repositorioServicioPrestado) {
        return new ServicioActualizarServicioPrestado(repositorioServicioPrestado);
    }

}
