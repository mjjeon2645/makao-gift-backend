package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class ProductService {
  private final ProductRepository productRepository;
  private PageRequest pageable;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Page<Product> products(int page) {
    Sort sort = Sort.by("id").descending();
    pageable = PageRequest.of(page - 1, 8, sort);

    return productRepository.findAll(pageable);
  }

  public Product detail(Long id) {
    Product selectedProduct = productRepository.getReferenceById(id);
    return selectedProduct;
  }

  public int getPages() {
    // pageable이 initialize가 안되었는데도 가능한가?
    return productRepository.findAll(pageable).getTotalPages();
  }
}
