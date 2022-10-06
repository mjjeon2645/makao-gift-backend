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
  public ProductsDto lists(
      @RequestParam(required = false, defaultValue = "1") int page
  ) {

    List<ProductDto> productDtos =  productService.products(page).stream()
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
