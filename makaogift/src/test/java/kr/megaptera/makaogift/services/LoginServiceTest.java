package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class LoginServiceTest {
  @Test
  void authenticate() {
    LoginService loginService = new LoginService();

    LoginResultDto loginResultDto =
        loginService.authenticate("mjjeon2645", "123!@#qweQWE");

    assertThat(loginResultDto.getAccessToken()).isNotNull();
    assertThat(loginResultDto.getName()).isEqualTo("전민지");
    assertThat(loginResultDto.getAmount()).isEqualTo(50_000L);
  }
}
