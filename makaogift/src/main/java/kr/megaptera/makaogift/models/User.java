package kr.megaptera.makaogift.models;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import org.springframework.security.crypto.password.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class User {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String userId;

  private String encodedPassword;

  private Long amount;

  public User() {
  }

  public User(Long id, String name, String userId) {
    this.id = id;
    this.name = name;
    this.userId = userId;
    this.amount = 50_000L;
  }

  public User(Long id, String name, String userId, Long amount) {
    this.id = id;
    this.name = name;
    this.userId = userId;
    this.amount = amount;
  }

  public Long id() {
    return id;
  }

  public String name() {
    return name;
  }

  public String userId() {
    return userId;
  }

  public Long amount() {
    return amount;
  }

  public boolean authenticate(String password, PasswordEncoder passwordEncoder) {
    return passwordEncoder.matches(password, encodedPassword);
  }

  public void changePassword(String password, PasswordEncoder passwordEncoder) {
    encodedPassword = passwordEncoder.encode(password);
  }

  public static User fake(String userId) {
    return new User(1L, "전민지", userId, 50_000L);
  }

  public RegistrationResultDto toRegistrationResultDto() {
    return new RegistrationResultDto(name, userId, amount);
  }

  public void pay(Long totalPrice) {
    if (this.amount < totalPrice) {
      throw new LowBalanceError();
    }
    this.amount -= totalPrice;
  }
}
