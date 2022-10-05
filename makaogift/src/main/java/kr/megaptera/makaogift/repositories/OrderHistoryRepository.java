package kr.megaptera.makaogift.repositories;

import kr.megaptera.makaogift.models.*;
import org.springframework.data.jpa.repository.*;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
