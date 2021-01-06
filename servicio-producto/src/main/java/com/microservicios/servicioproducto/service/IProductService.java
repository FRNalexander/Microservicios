package com.microservicios.servicioproducto.service;

import com.microservicios.servicioproducto.entity.Category;
import com.microservicios.servicioproducto.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantity);
}
