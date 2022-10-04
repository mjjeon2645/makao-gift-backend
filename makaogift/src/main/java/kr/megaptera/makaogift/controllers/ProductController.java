package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("products")
public class ProductController {
  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ProductsDto lists() {

    List<ProductDto> productDtos =  productService.products().stream()
        .map(Product::toProductDto).toList();

    return new ProductsDto(productDtos);
  }

  @GetMapping("{id}")
  public ProductDto detail(
      @PathVariable("id") Long id
  ) {
    Product selectedProduct = productService.detail(id);

    return selectedProduct.toProductDto();
  }


}
