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

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> products() {
//    Pageable pageable = PageRequest.of(page - 1, 8);
    return productRepository.findAll();
  }
}
