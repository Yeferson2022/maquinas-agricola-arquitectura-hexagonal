package com.ceiba.servicioPrestado.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.ServicioPrestado;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicioPrestado.servicio.testdatabuilder.ServicioPrestadoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioPrestadoTest {

    @Test
    void deberiaFallarSinIdentificacionMaquina() {

        //Arrange
        ServicioPrestadoTestDataBuilder servicioPrestadoTestDataBuilder = new ServicioPrestadoTestDataBuilder().conIdentificacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioPrestadoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion de la maquina");
    }

    @Test
    void deberiaFallarSinCantidadHorasCargas() {

        //Arrange
        ServicioPrestadoTestDataBuilder servicioPrestadoTestDataBuilder = new ServicioPrestadoTestDataBuilder().conCantidadHorasCargas(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioPrestadoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad de horas o cargas");
    }

    @Test
    void deberiaFallarSinIdCliente() {

        //Arrange
        ServicioPrestadoTestDataBuilder servicioPrestadoTestDataBuilder = new ServicioPrestadoTestDataBuilder().conCliente(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioPrestadoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "se debe ingresar el id del cliente");
    }

    @Test
    void deberiaFallarSinTipoTrabajo() {

        //Arrange
        ServicioPrestadoTestDataBuilder servicioPrestadoTestDataBuilder = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioPrestadoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de trabajo");
    }

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
        ServicioPrestadoTestDataBuilder servicioPrestadoTestDataBuilder = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(4);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPrestadoTestDataBuilder.build(), ExcepcionValorInvalido.class, "El tipo de trabajo no esta permitido en el sistema");
    }

    @Test
    public void validarFechaMantenimientoSinContarFinesDeSemanaTipoDeTrabajoUnoTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(1).build();
        LocalDate date = servicioPrestado.getFechaUltimoMantenimiento();
        LocalDate fechaMantenimiento = addDias(date, 40);
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
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getFechaProximoMantenimiento(), fechaMantenimiento);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoUnoTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(1).build();
        Long total = 40000 * servicioPrestado.getCantidadHorasCargas();
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getTotal(), total);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoDosTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(2).build();
        Long total = 50000 * servicioPrestado.getCantidadHorasCargas();
        // act
        servicioPrestado.calcularTotal();
        // assert
        Assertions.assertEquals(servicioPrestado.getTotal(), total);
    }

    @Test
    public void validarTotalDelTrabajoAlClienteTipoDeTrabajoTresTest() {
        ServicioPrestado servicioPrestado = new ServicioPrestadoTestDataBuilder().conTipoTrabajo(3).build();
        Long total = 20000 * servicioPrestado.getCantidadHorasCargas();
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
