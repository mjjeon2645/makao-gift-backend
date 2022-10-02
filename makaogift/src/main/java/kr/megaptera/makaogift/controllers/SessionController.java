package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("session")
public class SessionController {
  private LoginService loginService;

  public SessionController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoginResultDto login(
      @RequestBody LoginRequestDto loginRequestDto
  ) {

    if (!loginRequestDto.getPassword().equals("123!@#qweQWE")) {
      throw new LoginFailed();
    }

    return loginService.authenticate(loginRequestDto.getUserId(), loginRequestDto.getPassword());
  }

  @ExceptionHandler(LoginFailed.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String loginFailed() {
    return "아이디 혹은 비밀번호가 맞지 않습니다";
  }
}
