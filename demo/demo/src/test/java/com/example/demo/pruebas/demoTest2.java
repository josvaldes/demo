package com.example.demo.pruebas;

import com.example.demo.controller.ProductoController;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class demoTest2 {

    // Crear un objeto builder de Producto
    //Producto.Builder productoBuilder = Producto.builder();

    @Test
    void testGuardarProducto(){
        //given - dado una condicion inicial
        //Producto producto1 = productoBuilder
                .id("1")
                .nombre("producto 1")
                .precio(10.1)
                .build();
        //accion o comportamiento a probar
        Mono<Producto> productoGuardo = ProductoController.crearProducto(producto1);

        //then - verificar salida
        assertThat(productoGuardo).isNotNull();
        assertThat(productoGuardo.getId()).isGreaterThan("1");
    }
}
