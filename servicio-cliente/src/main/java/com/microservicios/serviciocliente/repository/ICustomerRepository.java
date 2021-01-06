package com.microservicios.serviciocliente.repository;

import com.microservicios.serviciocliente.entity.Customer;
import com.microservicios.serviciocliente.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByNumberId(String numberId);
    public List<Customer> findByLastName(Customer customer);
    public List<Customer> findByRegion(Region region);
}
