package com.example.demo.pruebas;

import com.example.demo.controller.ProductoController;
import com.example.demo.DemoApplication;
import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringJUnitConfig
@ComponentScan(basePackages = {"com.example.demo.controller", "com.example.demo.service"})
@SpringBootTest(classes = DemoApplication.class)
public class demoTest {

    @InjectMocks
    @Autowired
    private ProductoController productoController;

    @Mock
    @Autowired
    private ProductoService productoService;

    @Test
    public void miMetodoDePrueba1() {
        // Datos de prueba
        Producto mockProducto = new Producto();
        mockProducto.setId("1");
        mockProducto.setNombre("Ejemplo de producto");

        // Simula el servicio para devolver el producto mock cuando se llama con el ID 1
        when(productoService.obtenerProductoPorId("1")).thenReturn(Mono.just(mockProducto));

        // Realiza la solicitud GET simulada
        WebTestClient webTestClient = WebTestClient.bindToController(productoController).build();
        webTestClient.get()
                .uri("/productos/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Producto.class)
                .isEqualTo(mockProducto);
    }
}

