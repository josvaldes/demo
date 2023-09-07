package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@RestController
public class ProductoController {
    @Autowired
    private static ProductoService productoService;


    @PostMapping("/productos")
    public static Mono<Producto> crearProducto(@RequestBody Producto producto) {
        // Imprimir o loggear el objeto antes de guardarlo
        System.out.println("Objeto a guardar: " + producto.toString());

        // Lógica para guardar el producto en la base de datos
        Mono<Producto> productoGuardado = productoService.guardarProducto(producto);

        // Imprimir o loggear el objeto después de guardarlo
        productoGuardado.subscribe(savedProducto -> {
            System.out.println("Objeto guardado: " + savedProducto.toString());
        });


        return productoGuardado;
    }

    @GetMapping("/productos/{id}")
    public Mono<Producto> obtenerProductoPorId(@PathVariable String id) {

        return productoService.obtenerProductoPorId(id);
    }
}
