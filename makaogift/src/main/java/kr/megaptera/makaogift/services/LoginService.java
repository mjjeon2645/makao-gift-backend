package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class LoginService {
  private final UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  public LoginService(UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User login(String userId, String password) {
    // 1. user 정보가 있는지 찾고
    User found = userRepository.findByUserId(userId)
        .orElseThrow(() -> new LoginFailed());

    // 2. 그다음 그 user의 비밀번호와 비교하고.
    if (!found.authenticate(password, passwordEncoder)) {
      throw new LoginFailed();
    }

    return found;
  }

  public Long balance(String userId) {
    User found = userRepository.findByUserId(userId)
        .orElseThrow(() -> new LoginFailed());

    return found.amount();
  }
}
