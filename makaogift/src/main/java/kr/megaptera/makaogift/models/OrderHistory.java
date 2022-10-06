package kr.megaptera.makaogift.models;

import kr.megaptera.makaogift.dtos.*;
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

  private String imgUrl;

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

  public OrderHistory(Long id, String sender, String productName,
                      String manufacturer, Long volume, Long totalPrice,
                      LocalDateTime createdAt, String receiver, String address,
                      String message, String imgUrl) {
    this.id = id;
    this.sender = sender;
    this.productName = productName;
    this.manufacturer = manufacturer;
    this.volume = volume;
    this.totalPrice = totalPrice;
    this.createdAt = createdAt;
    this.receiver = receiver;
    this.address = address;
    this.message = message;
    this.imgUrl = imgUrl;
  }

  public OrderHistoryDto toDto() {

    String orderedDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    return new OrderHistoryDto(id, productName, manufacturer, volume, totalPrice,
        orderedDate, receiver, address, message, imgUrl);
  }

  public Long id() {
    return id;
  }

  public String sender() {
    return sender;
  }

  public String productName() {
    return productName;
  }

  public String manufacturer() {
    return manufacturer;
  }

  public Long volume() {
    return volume;
  }

  public Long totalPrice() {
    return totalPrice;
  }

  public LocalDateTime createdAt() {
    return createdAt;
  }

  public String receiver() {
    return receiver;
  }

  public String address() {
    return address;
  }

  public String message() {
    return message;
  }

  public String imgUrl() {
    return imgUrl;
  }
}
