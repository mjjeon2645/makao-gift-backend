package kr.megaptera.makaogift.repositories;

import kr.megaptera.makaogift.models.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUserId(String userId);
}
