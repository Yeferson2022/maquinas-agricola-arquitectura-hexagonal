package com.ceiba.cliente.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre de cliente";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificacion";
    private static final String SE_DEBE_INGRESAR_LA_VEREDA = "Se debe ingresar la vereda ";


    private Long id;
    private String nombre;
    private String identificacion;
    private String vereda;

    public Cliente(Long id, String nombre, String identificacion, String vereda) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
        validarObligatorio(vereda, SE_DEBE_INGRESAR_LA_VEREDA);

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.vereda = vereda;
    }

}
