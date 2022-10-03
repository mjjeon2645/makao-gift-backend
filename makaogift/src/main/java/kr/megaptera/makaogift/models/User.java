package kr.megaptera.makaogift.models;

import kr.megaptera.makaogift.dtos.*;
import org.springframework.security.crypto.password.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class User {

  @Id
  @GeneratedValue
  private Long id;

  private String userId;

  private String encodedPassword;

  private String name;

  private Long amount;

  public User() {
  }

  public User(Long id, String userId, String name) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.amount = 50_000L;
  }

  public User(Long id, String userId, String name, Long amount) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.amount = amount;
  }

  public Long id() {
    return id;
  }

  public String userId() {
    return userId;
  }

  public String name() {
    return name;
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
    return new User(1L, userId, "전민지", 50_000L);
  }

  public RegistrationResultDto toRegistrationResultDto() {
    return new RegistrationResultDto(name, userId, amount);
  }
}
