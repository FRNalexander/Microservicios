package com.microservicios.serviciocompras.client;

import com.microservicios.serviciocompras.modelo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "servicio-producto")
@RequestMapping(value = "/products")
public interface ProductClient {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id, @RequestParam(value = "quantity", required = true) Double quantity);
}
