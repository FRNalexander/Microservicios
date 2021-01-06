package com.microservicios.servicioproducto;

import com.microservicios.servicioproducto.entity.Category;
import com.microservicios.servicioproducto.entity.Product;
import com.microservicios.servicioproducto.repository.IProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    private IProductRepository productRepository;

    //cuando busco una categoria deberia de retornarme una lista de productos
    @Test
    public void whenFindBycategory_thenReturListProduct(){
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("100"))
                .price(Double.parseDouble("1300"))
                .status("Created")
                .createAt(new Date()).build();

        productRepository.save(product01);
        List<Product> found = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(found.size()).isEqualTo(3);

    }
}
