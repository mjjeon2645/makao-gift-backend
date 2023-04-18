package kr.megaptera.makaogift.exceptions;

public class CheckPasswordError extends RuntimeException {
  public CheckPasswordError() {
    super("비밀번호가 일치하지 않습니다");
  }
}
