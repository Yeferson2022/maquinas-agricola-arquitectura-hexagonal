package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    @DisplayName("Deberia crear correctamente el cliente")
    void deberiaCrearCorrectamenteElCliente() {

        //act
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, cliente.getId());
        assertEquals("Yeferson", cliente.getNombre());
        assertEquals("1094580", cliente.getIdentificacion());
        assertEquals("Bello Valle", cliente.getVereda());
    }

    @Test
    void deberiaFallarSinNombreDeCliente() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de cliente");
    }

    @Test
    void deberiaFallarSinIdentificacion() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdentificacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion");
    }

    @Test
    void deberiaFallarSinVereda() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conVereda(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la vereda");
    }


}
