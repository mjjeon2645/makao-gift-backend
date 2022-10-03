package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class LoginServiceTest {
  private LoginService loginService;
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);

    passwordEncoder = new Argon2PasswordEncoder();

    loginService = new LoginService(userRepository, passwordEncoder);
  }

  @Test
  void loginSuccess() {
    String userId = "mjjeon2645";

    User user = User.fake(userId);
    user.changePassword("test", passwordEncoder);

    given(userRepository.findByUserId(userId))
        .willReturn(Optional.of(user));

    User foundUser = loginService.login(userId, "test");

    assertThat(foundUser.name()).isEqualTo(user.name());
    assertThat(foundUser.amount()).isEqualTo(50_000L);
  }

  @Test
  void loginFailWithIncorrectUserId() {
    assertThrows(LoginFailed.class, () -> {
      loginService.login("xxx", "test");
    });
  }

  @Test
  void loginFailWithIncorrectPassword() {
    assertThrows(LoginFailed.class, () -> {
      loginService.login("mjjeon2645", "test111");
    });
  }
}
