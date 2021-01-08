package com.microservicios.serviciocompras.client;

import com.microservicios.serviciocompras.modelo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "servicio-cliente", fallback = CustomerHystrixFallbackFactory.class)
public interface CustomerClient {
    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
