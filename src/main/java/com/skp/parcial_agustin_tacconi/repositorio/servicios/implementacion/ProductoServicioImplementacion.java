package com.skp.parcial_agustin_tacconi.repositorio.servicios.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skp.parcial_agustin_tacconi.entidad.Producto;
import com.skp.parcial_agustin_tacconi.excepciones.EntidadNoEncontradaException;
import com.skp.parcial_agustin_tacconi.repositorio.ProductoRepositorio;
import com.skp.parcial_agustin_tacconi.repositorio.servicios.ProductoServicio;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service //
@RequiredArgsConstructor
@Transactional //si no se pone:Inconsistencia de Datos en Operaciones Combinadas y perdida de Atomicidad
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
    // Buscamos el producto por ID
    Optional<Producto> optionalProducto = productoRepositorio.findById(id);

    // Si optionalProducto NO contiene un valor 
    if (!optionalProducto.isPresent()) { 
        //entonces lanza la excepción personalizada EntidadNoEncontradaException
        throw new EntidadNoEncontradaException("Producto con ID " + id + " no encontrado para actualizar."); // <-- 'throw' en minúscula y en el bloque correcto
    }

    // Si el producto EXISTE 
    Producto existente = optionalProducto.get();

    // Actualizamos los campos del producto existente con los datos del producto recibido
    existente.setNombre(producto.getNombre());
    existente.setDescripcion(producto.getDescripcion());
    existente.setPrecio(producto.getPrecio());

    return productoRepositorio.save(existente);
    }
@Override
public void deleteProducto(Integer id) {
    // Antes de intentar eliminar, verificamos si el producto con ese ID existe en la base de datos
    if (!productoRepositorio.existsById(id)) {
         // Si NO existe, lanzamos nuestra excepción EntidadNoEncontradaException
         throw new EntidadNoEncontradaException("Producto con ID " + id + " no encontrado para eliminar.");
    }
    // Si el producto SÍ existe, procedemos a eliminarlo
    productoRepositorio.deleteById(id);
}
}