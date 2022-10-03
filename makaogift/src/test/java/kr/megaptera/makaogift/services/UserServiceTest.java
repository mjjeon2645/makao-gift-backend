package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class UserServiceTest {
  @Test
  void register() {
    PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();

    UserRepository userRepository = mock(UserRepository.class);

    UserService userService = new UserService(userRepository, passwordEncoder);

    User user = userService.register(new RegistrationRequestDto(
        "전민지", "mjjeon1234", "123qweQWE$", "123qweQWE$"));

    assertThat(user).isNotNull();
    assertThat(user.amount()).isEqualTo(50_000L);
    verify(userRepository).save(any());
  }
}
