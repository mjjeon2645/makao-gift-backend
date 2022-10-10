package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RegistrationResultDto register(
      @RequestBody RegistrationRequestDto registrationRequestDto
  ) {

    User user = userService.register(registrationRequestDto);

    return user.toRegistrationResultDto();
  }

  @ExceptionHandler(DuplicatedUserIdError.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String duplicatedUserIdError() {
    return "해당 아이디는 사용할 수 없습니다";
  }

  @ExceptionHandler(CheckPasswordError.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String checkPasswordError() {
    return "비밀번호가 일치하지 않습니다";
  }
}
