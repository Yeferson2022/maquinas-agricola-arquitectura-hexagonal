package com.ceiba.servicioPrestado.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.cliente.puerto.repositorio.RepositorioServicioPrestado;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.servicioPrestado.servicio.testdatabuilder.ServicioPrestadoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioPrestadoTest {

    @Test
    @DisplayName("Deberia crear correctamente el Trabajo de la Maquina")
    void deberiaCrearCorrectamenteElTrabajo() {

        //act
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, servicioPrestado.getId());
        assertEquals("Ford 6600", servicioPrestado.getIdentificacionMaquina());
        assertEquals(1, servicioPrestado.getTipoTrabajo());
        assertEquals(11, servicioPrestado.getCantidadHorasCargas());
    }

    @Test
    public void validarTipoDeTrabajoIncorrectoTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(4).build();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPrestado.calcularTotal(), ExcepcionValorInvalido.class, "El tipo de trabajo no esta permitido en el sistema");
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoUnoTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(1).build();
        LocalDate date = servicioPrestado.getFechaUltimoMantenimiento();
        LocalDate fechaMantenimiento = addDias(date, 40);
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoDosTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(2).build();
        LocalDate date = servicioPrestado.getFechaUltimoMantenimiento();
        LocalDate fechaMantenimiento = addDias(date, 50);
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoTresTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(3).build();
        LocalDate date = servicioPrestado.getFechaUltimoMantenimiento();
        LocalDate fechaMantenimiento = addDias(date, 60);
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoUnoTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(1).build();
        Long total = 40000 * servicioPrestado.getCantidadHorasCargas();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getTotal(), total);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoDosTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(2).build();
        Long total = 50000 * servicioPrestado.getCantidadHorasCargas();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getTotal(), total);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoTresTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(3).build();
        Long total = 20000 * servicioPrestado.getCantidadHorasCargas();
        RepositorioServicioPrestado repositorioServicioPrestado = Mockito.mock(RepositorioServicioPrestado.class);
        Mockito.when(repositorioServicioPrestado.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getTotal(), total);
    }

    public LocalDate addDias(LocalDate date, int workdays) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

}
