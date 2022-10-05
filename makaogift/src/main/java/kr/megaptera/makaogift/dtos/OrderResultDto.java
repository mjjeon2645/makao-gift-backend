package kr.megaptera.makaogift.dtos;

public class OrderResultDto {
  private String message;

  public OrderResultDto() {
  }

  public OrderResultDto(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}

