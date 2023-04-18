package kr.megaptera.makaogift.dtos;

public class RegistrationResultDto {
  private String name;
  private String userId;
  private Long amount;

  public RegistrationResultDto() {
  }

  public RegistrationResultDto(String name, String userId, Long amount) {
    this.name = name;
    this.userId = userId;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public String getUserId() {
    return userId;
  }

  public Long getAmount() {
    return amount;
  }
}
