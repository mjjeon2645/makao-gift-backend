package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import kr.megaptera.makaogift.utils.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("session")
public class SessionController {
  private final LoginService loginService;
  private final JwtUtil jwtUtil;

  public SessionController(LoginService loginService, JwtUtil jwtUtil) {
    this.loginService = loginService;
    this.jwtUtil = jwtUtil;
  }

  @GetMapping("me")
  public BalanceResultDto balance(
      @RequestAttribute("userId") String userId
  ) {
    Long balance = loginService.balance(userId);

    return new BalanceResultDto(balance);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoginResultDto login(
      @RequestBody LoginRequestDto loginRequestDto
  ) {

    User user = loginService.login(
        loginRequestDto.getUserId(),
        loginRequestDto.getPassword());

    String accessToken = jwtUtil.encode(user.userId());

    return new LoginResultDto(accessToken, user.name(), user.amount());
  }

  @ExceptionHandler(LoginFailed.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String loginFailed() {
    return "아이디 혹은 비밀번호가 맞지 않습니다";
  }
}
