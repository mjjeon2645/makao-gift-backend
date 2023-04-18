package kr.megaptera.makaogift.dtos;

public abstract class ErrorDto {
  private final int code;
  private final String message;

  protected ErrorDto(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
