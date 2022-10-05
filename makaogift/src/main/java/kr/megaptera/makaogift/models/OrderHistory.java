package kr.megaptera.makaogift.models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;

@Entity
public class OrderHistory {
  @Id
  @GeneratedValue
  private Long id;

  private String sender;

  private String productName;

  private String manufacturer;

  private Long volume;

  private Long totalPrice;

  @CreationTimestamp
  private LocalDateTime createdAt;

  private String receiver;

  private String address;

  private String message;

  public OrderHistory() {
  }

  public OrderHistory(String sender, String productName,
                      String manufacturer, Long volume, Long totalPrice,
                      String receiver, String address,
                      String message) {
    this.sender = sender;
    this.productName = productName;
    this.manufacturer = manufacturer;
    this.volume = volume;
    this.totalPrice = totalPrice;
    this.receiver = receiver;
    this.address = address;
    this.message = message;
  }
}
