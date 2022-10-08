package kr.megaptera.makaogift.dtos;

public class BalanceResultDto {
  private Long balance;

  public BalanceResultDto() {
  }

  public BalanceResultDto(Long balance) {
    this.balance = balance;
  }

  public Long getBalance() {
    return balance;
  }
}
