package com.skp.parcial_agustin_tacconi.repositorio.servicios;

import java.util.List;

import com.skp.parcial_agustin_tacconi.entidad.Producto;

public interface ProductoServicio {

    //Metodos para manejar las solicitudes HTTP
    //Contiene la logica, es la estructura de los metodos
    Producto buscarPorNombre(String nombre);
    Producto buscarPorDescripcion(String descripcion);
    List<Producto> findByPrecio(Double precio);
    List<Producto> findByNombreAndDescripcion(String nombre, String descripcion);
    List<Producto> getAllProducto();
    
    Producto guardar(Producto producto);
    Producto updateProducto(Integer id, Producto producto);
    void deleteProducto(Integer id);


}
