package kr.megaptera.makaogift.repositories;

import kr.megaptera.makaogift.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
//  Page<Product> findAll(Pageable pageable);
  List<Product> findAll();
}
