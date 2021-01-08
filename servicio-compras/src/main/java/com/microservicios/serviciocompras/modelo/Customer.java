package com.microservicios.serviciocompras.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;
    private String numberId;
    private String firstName;
    private String lastName;
    private String email;
    private String fothoUri;
    private Region region;
    private String state;
}
