package com.skp.parcial_agustin_tacconi.controlador;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skp.parcial_agustin_tacconi.entidad.Producto;
import com.skp.parcial_agustin_tacconi.repositorio.servicios.ProductoServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;    
import org.slf4j.LoggerFactory;    // Importar LoggerFactory


@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor

public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    private final ProductoServicio productoServicio;
    // Metodos para manejar las solicitudes HTTP

    //Crear Producto 1
    //Solo acepta@Request porque es un objeto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto producto) {
        logger.info("Listando todos los productos");
        Producto nuevo = productoServicio.guardar(producto);
        return ResponseEntity.ok(nuevo);
    }    
    //Listar todos los productos 2
    @GetMapping()
    public List<Producto> getAllProducto() {
        logger.info("Listando todos los productos");
        return productoServicio.getAllProducto();
   
    }
    //Buscar por nombre 3
    @GetMapping("/nombre/{nombre}")
    public Producto buscarPorNombre(@PathVariable String nombre) {
        logger.info("Buscando producto por nombre: {}", nombre);
        return productoServicio.buscarPorNombre(nombre);
    }
    //Buscar por descripcion 4
    @GetMapping("/descripcion/{descripcion}")
    public Producto buscarPorDescripcion(@PathVariable String descripcion) {
        logger.info("Buscando producto por descripcion: {}", descripcion);
        return productoServicio.buscarPorDescripcion(descripcion);
    }
    //Buscar por precio 5
    @GetMapping("/precio/{precio}")
    public List<Producto> findbyprecio(@PathVariable Double precio){
        logger.info("Buscando producto por precio: {}", precio);
        return productoServicio.findByPrecio(precio);   
    }
    //Buscar por nombre y descripcion 6
    @GetMapping("/filtro/{nombre}/{descripcion}")
    public List<Producto> buscarPorNombreYDescripcion(@PathVariable String nombre, @PathVariable String descripcion) {
        logger.info("Buscando producto por nombre: {} y descripcion: {}", nombre, descripcion);
        return productoServicio.findByNombreAndDescripcion(nombre, descripcion);
    }
    //Actualizar producto 7
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @Valid @RequestBody Producto producto) {
    Producto actualizado = productoServicio.updateProducto(id, producto);
    logger.info("Producto actualizado: {}", actualizado);
    return ResponseEntity.ok(actualizado);
    }
    //Eliminar producto 8
    @DeleteMapping("/eliminar/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        logger.info("Eliminando producto con id: {}", id);
        productoServicio.deleteProducto(id);
    }
    
}
