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
                      String message) {
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
  }

  public OrderHistoryDto toDto() {

    String orderedDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    String imgUrl = "imgUrl";

    // TODO. OrderHistory 객체에 ImgUrl 항목 빠졌음. 추가할 것

    return new OrderHistoryDto(id, productName, manufacturer, volume, totalPrice,
        orderedDate, receiver, address, message, imgUrl);
  }
}
