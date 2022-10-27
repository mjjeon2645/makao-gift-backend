package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

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

    List<Product> products = List.of(
        new Product(1L, "누구나 좋아하는 지방시 선물세트", 10_000L, "GIVENCHY",
            "지방시 선물세트 누구나 다 좋아합니다", "imgUrl"),
        new Product(2L, "맛있는 횡성한우", 35_000L, "횡성농협",
            "횡성한우로 맛있는 식사반찬!", "imgUrl"));

    Sort sort = Sort.by("id").descending();
    int page = 1;
    Pageable pageable = PageRequest.of(page - 1, 8, sort);

    given(productRepository.findAll(pageable))
        .willReturn(new PageImpl<>(products, pageable, products.size()));

    given(productRepository.getReferenceById(1L)).willReturn(
        new Product(1L, "누구나 좋아하는 지방시 선물세트", 10_000L, "GIVENCHY",
            "지방시 선물세트 누구나 다 좋아합니다", "imgUrl")
    );
  }

  @Test
  void products() {
    int page = 1;
    Page<Product> products = productService.products(page);

    assertThat(products.getTotalElements()).isEqualTo(2);
    assertThat(products.getTotalPages()).isEqualTo(1);
  }

  @Test
  void detail() {
    Product selectedProduct = productService.detail(1L);

    assertThat(selectedProduct.getName()).isEqualTo("누구나 좋아하는 지방시 선물세트");
    assertThat(selectedProduct.getPrice()).isEqualTo(10_000L);

    verify(productRepository).getReferenceById(any());
  }
}
