package com.microservicios.servicioproducto;

import com.microservicios.servicioproducto.entity.Category;
import com.microservicios.servicioproducto.entity.Product;
import com.microservicios.servicioproducto.repository.IProductRepository;
import com.microservicios.servicioproducto.service.IProductService;
import com.microservicios.servicioproducto.service.ProductServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private IProductRepository productRepository;

    private IProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImp(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenvalidGetId_thenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidStock_thenReturnNewStock(){
        Product stock = productService.updateStock(1L, Double.parseDouble("3"));
        Assertions.assertThat(stock.getStock()).isEqualTo(8.0);
    }
}
