package kr.megaptera.makaogift.dtos;

public class OrderResultDto {
  private Long amount;


  public OrderResultDto() {
  }

  public OrderResultDto(Long amount) {
    this.amount = amount;
  }

  public Long getAmount() {
    return amount;
  }
}
