package com.microservicios.serviciocliente.service;

import com.microservicios.serviciocliente.entity.Customer;
import com.microservicios.serviciocliente.entity.Region;
import com.microservicios.serviciocliente.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurstomerServiceImp implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomerByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer createCustomer = customerRepository.findByNumberId(customer.getNumberId());
        if (createCustomer == null){
            return null;
        }
        createCustomer.setState("Created");
        return customerRepository.save(createCustomer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer updateCustomer = getCustomer(customer.getId());
        if (updateCustomer == null){
            return null;
        }
        updateCustomer.setFirstName(customer.getFirstName());
        updateCustomer.setLastName(customer.getLastName());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setFothoUri(customer.getFothoUri());
        return customerRepository.save(updateCustomer);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer deleteCustomer = getCustomer(customer.getId());
        if (deleteCustomer == null){
            return null;
        }
        deleteCustomer.setState("Delete");
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
