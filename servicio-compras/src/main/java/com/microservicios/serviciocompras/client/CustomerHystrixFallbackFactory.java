package com.microservicios.serviciocompras.client;

import com.microservicios.serviciocompras.modelo.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixFallbackFactory implements  CustomerClient{
    @Override
    public ResponseEntity<Customer> getCustomer(long id) {
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .fothoUri("none").build();
        return ResponseEntity.ok(customer);
    }
}
