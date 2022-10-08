package kr.megaptera.makaogift.repositories;

import kr.megaptera.makaogift.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
  Page<OrderHistory> findAllBySender(String sender, Pageable pageable);
}
