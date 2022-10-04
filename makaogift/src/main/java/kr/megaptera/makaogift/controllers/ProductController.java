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
  public List<ProductDto> lists() {
    return productService.products().stream()
        .map(Product::toProductDto).toList();
  }

//  @GetMapping
//  public List<ProductDto> lists() {
//    return productService.products().stream()
//        .map(Product::toProductDto).toList();
//  }
}
