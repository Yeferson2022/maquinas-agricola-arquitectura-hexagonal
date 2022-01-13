package com.ceiba.maquinaTrabajo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.MaquinaTrabajo;
import com.ceiba.cliente.puerto.repositorio.RepositorioMaquina;
import com.ceiba.cliente.servicio.ServicioCrearMaquinaTrabajo;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.maquinaTrabajo.servicio.testdatabuilder.MaquinaTrabajoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearMaquinaTrabajoTest {


    @Test
    public void validarTipoDeTrabajoIncorrectoTest() {
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(4).build();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo), ExcepcionValorInvalido.class, "El tipo de trabajo no esta permitido en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el Trabajo de manera correcta")
    void deberiaCrearElTrabajoDeManeraCorrecta() {
        // arrange
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().build();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioMaquina.crear(maquinaTrabajo)).thenReturn(10L);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        Long idCliente = servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        //- assert
        assertEquals(10L, idCliente);
        Mockito.verify(repositorioMaquina, Mockito.times(1)).crear(maquinaTrabajo);
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoUnoTest() {
        LocalDate date = LocalDate.now();
        String fechaMantenimiento = addDias(date, 40);
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(1).build();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        // assert
        Assertions.assertEquals(maquinaTrabajo.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoDosTest() {
        LocalDate date = LocalDate.now();
        String fechaMantenimiento = addDias(date, 50);
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(2).build();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        // assert
        Assertions.assertEquals(maquinaTrabajo.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoTresTest() {
        LocalDate date = LocalDate.now();
        String fechaMantenimiento = addDias(date, 60);
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(3).build();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        // assert
        Assertions.assertEquals(maquinaTrabajo.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoUnoTest() {
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(1).build();
        Long total = 40000 * maquinaTrabajo.getCantidadHorasCargas();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        // assert
        Assertions.assertEquals(maquinaTrabajo.getTotal(), total);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoDosTest() {
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(2).build();
        Long total = 50000 * maquinaTrabajo.getCantidadHorasCargas();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        // assert
        Assertions.assertEquals(maquinaTrabajo.getTotal(), total);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoTresTest() {
        MaquinaTrabajo maquinaTrabajo = new MaquinaTrabajoTestDataBuilder().conTipoTrabajo(3).build();
        Long total = 20000 * maquinaTrabajo.getCantidadHorasCargas();
        RepositorioMaquina repositorioMaquina = Mockito.mock(RepositorioMaquina.class);
        Mockito.when(repositorioMaquina.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearMaquinaTrabajo servicioCrearMaquinaTrabajo = new ServicioCrearMaquinaTrabajo(repositorioMaquina);
        // act
        servicioCrearMaquinaTrabajo.ejecutar(maquinaTrabajo);
        // assert
        Assertions.assertEquals(maquinaTrabajo.getTotal(), total);
    }

    public String addDias(LocalDate date, int workdays) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateFormat.format(result);
    }

}
