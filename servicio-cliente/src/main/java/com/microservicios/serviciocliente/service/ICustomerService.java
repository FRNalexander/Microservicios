package com.microservicios.serviciocliente.service;

import com.microservicios.serviciocliente.entity.Customer;
import com.microservicios.serviciocliente.entity.Region;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findCustomerAll();
    public List<Customer> findCustomerByRegion(Region region);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public Customer getCustomer(Long id);
}
