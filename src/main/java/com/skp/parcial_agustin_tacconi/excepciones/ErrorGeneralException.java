package com.skp.parcial_agustin_tacconi.excepciones;

public class ErrorGeneralException extends RuntimeException {

    public ErrorGeneralException(String mensaje) {
        super(mensaje);
    }
}
// Esta excepción se lanza para indicar un error general en la aplicación.
// Por ejemplo, si ocurre un error inesperado durante la ejecución de una operación, lanzamos esta excepción para notificar al usuario que algo salió mal.