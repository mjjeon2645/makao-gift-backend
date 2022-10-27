package kr.megaptera.makaogift.models;

import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class UserTest {
  @Test
  void authenticate() {
    PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();

    String userId = "mjjeon2645";
    User user = User.fake(userId);

    UserRepository userRepository = mock(UserRepository.class);
    given(userRepository.findByUserId(userId)).willReturn(Optional.of(user));

    user.changePassword("test", passwordEncoder);

    assertThat(user.authenticate("test", passwordEncoder)).isTrue();
    assertThat(user.authenticate("test111", passwordEncoder)).isFalse();
  }
}
