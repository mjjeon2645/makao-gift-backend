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
    // 이건 파라미터로 들어온 page 숫자에 대한 1개의 페이지만 가지고 나감.
    List<ProductDto> productDtos =  productService.products(page).stream()
        .map(Product::toProductDto).toList();

    // 페이지 말고 전체에 대한 뭔가를 가지고 나가야 프론트에서 뭘 해줄것같은데..(getTotalPage가 페이지 수란다.)
    int totalPageNumbers = productService.getPages();

    return new ProductsDto(productDtos, totalPageNumbers);
  }

  @GetMapping("{id}")
  public ProductDto detail(
      @PathVariable("id") Long id
  ) {
    Product selectedProduct = productService.detail(id);

    return selectedProduct.toProductDto();
  }
}
