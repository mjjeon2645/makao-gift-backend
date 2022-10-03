package kr.megaptera.makaogift.repositories;

import kr.megaptera.makaogift.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserId(String userId);
}
