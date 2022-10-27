package kr.megaptera.makaogift.exceptions;

public class DuplicatedUserIdError extends RuntimeException {
  public DuplicatedUserIdError() {
    super("해당 아이디는 사용할 수 없습니다");
  }
}
