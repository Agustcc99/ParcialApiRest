package com.skp.parcial_agustin_tacconi.repositorio.servicios.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skp.parcial_agustin_tacconi.entidad.Producto;
import com.skp.parcial_agustin_tacconi.repositorio.ProductoRepositorio;
import com.skp.parcial_agustin_tacconi.repositorio.servicios.ProductoServicio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServicioImplementacion implements ProductoServicio {
    private final ProductoRepositorio productoRepositorio;

    @Override
    public Producto buscarPorNombre(String nombre) {
        return productoRepositorio.findByNombre(nombre);
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        return productoRepositorio.findByDescripcion(descripcion);
    }

    @Override
    public List<Producto> findByPrecio(Double precio) {
        return productoRepositorio.findByPrecio(precio);
    }

    @Override
    public List<Producto> findByNombreAndDescripcion(String nombre, String descripcion) {
        return productoRepositorio.findByNombreAndDescripcion(nombre, descripcion);
    }

    @Override
    public List<Producto> getAllProducto() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
public Producto updateProducto(Integer id, Producto producto) {
    Optional<Producto> optionalProducto = productoRepositorio.findById(id);
    
    if (optionalProducto.isPresent()) {
        Producto existente = optionalProducto.get();
        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        return productoRepositorio.save(existente);
    } else {
        return null; // O podrías lanzar una excepción si querés manejarlo mejor
    }
}


    @Override
    public void deleteProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }
}