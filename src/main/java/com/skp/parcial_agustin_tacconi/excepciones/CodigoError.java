package com.skp.parcial_agustin_tacconi.excepciones;

public enum CodigoError {

    PRODUCTO_NO_ENCONTRADO("Producto no encontrado"),
    ERROR_INTERNO("Error interno del servidor");

    private final String descripcion;

    CodigoError(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getCodigo() {
        return name();
    }
}
