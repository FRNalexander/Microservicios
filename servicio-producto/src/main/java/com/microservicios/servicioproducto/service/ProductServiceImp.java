package com.microservicios.servicioproducto.service;

import com.microservicios.servicioproducto.entity.Category;
import com.microservicios.servicioproducto.entity.Product;
import com.microservicios.servicioproducto.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService{
    //@Autowired
    private final IProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("Created");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product producdb = getProduct(product.getId());
        if (producdb == null){
            return null;
        }
        producdb.setName(product.getName());
        producdb.setDescription(product.getDescription());
        producdb.setCategory(product.getCategory());
        producdb.setPrice(product.getPrice());
        return productRepository.save(producdb);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productdb = getProduct(id);
        if (productdb == null){
            return null;
        }
        productdb.setStatus("Delete");
        return productRepository.save(productdb);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productdb = getProduct(id);
        if (productdb == null){
            return null;
        }
        Double stock = productdb.getStock() + quantity;
        productdb.setStock(stock);
        return productRepository.save(productdb);
    }
}
