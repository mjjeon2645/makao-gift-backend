package kr.megaptera.makaogift.dtos;

public class RegistrationRequestDto {
  private String name;
  private String userId;
  private String password;
  private String checkPassword;

  public RegistrationRequestDto() {
  }

  public RegistrationRequestDto(String name, String userId, String password, String checkPassword) {
    this.name = name;
    this.userId = userId;
    this.password = password;
    this.checkPassword = checkPassword;
  }

  public String getName() {
    return name;
  }

  public String getUserId() {
    return userId;
  }

  public String getPassword() {
    return password;
  }

  public String getCheckPassword() {
    return checkPassword;
  }
}
