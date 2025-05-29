package com.skp.parcial_agustin_tacconi.excepciones;

public class EntidadNoEncontradaException extends RuntimeException {

    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
// Esta excepción se lanza cuando no se encuentra una entidad en la base de datos.
// Por ejemplo, si intentamos buscar un producto por su ID y no existe, lanzamos esta excepción.