package com.skp.parcial_agustin_tacconi.controlador;


import java.util.List;

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

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor

public class ProductoControlador {

    private final ProductoServicio productoServicio;
    // Aquí puedes agregar los métodos para manejar las solicitudes HTTP (GET, POST, PUT, DELETE)

    //Crear Producto 1
    //Solo acepta@Request porque es un objeto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoServicio.guardar(producto);
    }
    //Listar todos los productos 2
    @GetMapping()
    public List<Producto> getAllProducto() {
        return productoServicio.getAllProducto();
    }
    //Buscar por nombre 3
    @GetMapping("/nombre/{nombre}")
    public Producto buscarPorNombre(@PathVariable String nombre) {
        return productoServicio.buscarPorNombre(nombre);
    }
    //Buscar por descripcion 4
    @GetMapping("/descripcion/{descripcion}")
    public Producto buscarPorDescripcion(@PathVariable String descripcion) {
        return productoServicio.buscarPorDescripcion(descripcion);
    }
    //Buscar por precio 5
    @GetMapping("/precio/{precio}")
    public List<Producto> findbyprecio(@PathVariable Double precio){
        return productoServicio.findByPrecio(precio);   
    }
    //Buscar por nombre y descripcion 6
    @GetMapping("/filtro/{nombre}/{descripcion}")
    public List<Producto> buscarPorNombreYDescripcion(@PathVariable String nombre, @PathVariable String descripcion) {
        return productoServicio.findByNombreAndDescripcion(nombre, descripcion);
    }
    //Actualizar producto 7
    @PutMapping("/actualizar/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoServicio.updateProducto(id, producto);
    }
    //Eliminar producto 8
    @DeleteMapping("/eliminar/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoServicio.deleteProducto(id);
    }
}
