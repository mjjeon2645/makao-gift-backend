package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @BeforeEach
  void setUp() {
    given(productService.products()).willReturn(List.of(
        new Product(1L, "누구나 좋아하는 지방시 선물세트", 10_000L, "GIVENCHY",
            "지방시 선물세트 누구나 다 좋아합니다", "imgUrl"),
        new Product(2L, "새로나온 아이폰14", 10_000L, "애플", "아이폰 14 싸다", "imgUrl")
    ));
  }

  @Test
  void lists() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/products"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("\"manufacturer\":")
        ));
  }
}
