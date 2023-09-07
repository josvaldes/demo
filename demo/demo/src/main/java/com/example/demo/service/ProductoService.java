package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Mono<Producto> guardarProducto(Producto producto) {
        // Lógica para guardar el producto en la base de datos
        return productoRepository.save(producto);
    }

    public Mono<Producto> obtenerProductoPorId(String id) {
        // Lógica para obtener un producto por su ID
        return productoRepository.findById(id);
    }

}
