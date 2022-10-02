package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import kr.megaptera.makaogift.utils.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class LoginService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private JwtUtil jwtUtil;


  public LoginService(UserRepository userRepository,
                      PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
  }

  public LoginResultDto authenticate(String userId, String password) {

    User found = userRepository.findByUserId(userId);

    found.authenticate(password, passwordEncoder);

    String accessToken = jwtUtil.encode(userId);

    return new LoginResultDto(accessToken, found.name(), found.amount());
  }
}
