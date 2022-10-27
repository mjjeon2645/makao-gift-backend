package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User register(RegistrationRequestDto registrationRequestDto) {
    String name = registrationRequestDto.getName();
    String userId = registrationRequestDto.getUserId();
    String password = registrationRequestDto.getPassword();
    String checkPassword = registrationRequestDto.getCheckPassword();

    // 1. 동일한 아이디가 있는 경우 fail
    User user = userRepository.findByUserId(userId).orElse(null);

    if (user != null) {
      throw new DuplicatedUserIdError();
    }

    // 2. 두 패스워드가 동일하지 않을 경우 fail => 나머지 예외는 모두 프론트에서 처리 가능
    if (!password.equals(checkPassword)) {
      throw new CheckPasswordError();
    }

    User createdUser = new User(null, name, userId);

    createdUser.changePassword(password, passwordEncoder);

    userRepository.save(createdUser);

    return createdUser;
  }
}
