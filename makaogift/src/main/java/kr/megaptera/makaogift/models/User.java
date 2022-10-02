package kr.megaptera.makaogift.models;

import org.springframework.security.crypto.password.*;

import javax.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue
  private Long id;

  private String encodedPassword;

  private String name;

  private Long amount;

  public User() {
  }

  public User(Long id, String name, Long amount) {
    this.id = id;
    this.name = name;
    this.amount = amount;
  }

  public Long id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Long amount() {
    return amount;
  }

  public String authenticate(String password, PasswordEncoder passwordEncoder) {
    return null;
  }
}
