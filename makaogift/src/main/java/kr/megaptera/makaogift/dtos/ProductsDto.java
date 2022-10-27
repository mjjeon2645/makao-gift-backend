package kr.megaptera.makaogift.dtos;

import java.util.*;

public class ProductsDto {
  private List<ProductDto> products;

  private int totalPageNumbers;

  public ProductsDto(List<ProductDto> productDtos, int totalPageNumbers) {
    this.products = productDtos;
    this.totalPageNumbers = totalPageNumbers;
  }

  public List<ProductDto> getProducts() {
    return products;
  }

  public int getTotalPageNumbers() {
    return totalPageNumbers;
  }
}
