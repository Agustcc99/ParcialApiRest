package com.skp.parcial_agustin_tacconi.repositorio;


import com.skp.parcial_agustin_tacconi.entidad.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar productos por nombre, categoría, etc.

    Producto findByNombre(String nombre);
    Producto findByDescripcion(String descripcion);
    List <Producto> findByPrecio(Double precio);
    List<Producto> findByNombreAndDescripcion(String nombre, String descripcion);
    

}
