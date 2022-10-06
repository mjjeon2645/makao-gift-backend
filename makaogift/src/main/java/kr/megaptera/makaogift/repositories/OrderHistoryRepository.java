package kr.megaptera.makaogift.repositories;

import kr.megaptera.makaogift.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
  List<OrderHistory> findAllBySender(String sender);
}
