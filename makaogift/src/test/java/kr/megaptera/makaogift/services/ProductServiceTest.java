package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductServiceTest {
  private ProductService productService;
  private ProductRepository productRepository;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);

    productService = new ProductService(productRepository);

    given(productRepository.findAll()).willReturn(List.of(
        new Product(1L, "누구나 좋아하는 지방시 선물세트", 10_000L, "GIVENCHY", "지방시 선물세트 누구나 다 좋아합니다", "imgUrl"),
        new Product(2L, "새로나온 아이폰14", 10_000L, "애플", "아이폰 14 싸다", "imgUrl")
    ));

    given(productRepository.getReferenceById(1L)).willReturn(
        new Product(1L, "누구나 좋아하는 지방시 선물세트", 10_000L, "GIVENCHY", "지방시 선물세트 누구나 다 좋아합니다", "imgUrl")
    );
  }

  @Test
  void products() {
    List<Product> products = productService.products();

    assertThat(products).hasSize(2);
    assertThat(products.get(1).getName()).isEqualTo("새로나온 아이폰14");
  }

  @Test
  void detail() {
    Product selectedProduct = productService.detail(1L);

    assertThat(selectedProduct.getName()).isEqualTo("누구나 좋아하는 지방시 선물세트");
    assertThat(selectedProduct.getPrice()).isEqualTo(10_000L);

    verify(productRepository).getReferenceById(any());
  }
}
