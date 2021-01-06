package com.microservicios.servicioproducto.repository;

import com.microservicios.servicioproducto.entity.Category;
import com.microservicios.servicioproducto.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
}
