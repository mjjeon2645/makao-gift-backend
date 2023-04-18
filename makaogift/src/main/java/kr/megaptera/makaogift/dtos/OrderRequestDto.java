package kr.megaptera.makaogift.dtos;

import org.hibernate.validator.constraints.*;

import javax.validation.constraints.NotBlank;

public class OrderRequestDto {
  @NotBlank(message = "성함을 입력해주세요")
  private String receiver;

  @NotBlank(message = "주소를 입력해주세요")
  private String address;

  @Length(max = 100)
  private String message;

  private Long productId;

  private Long volume;

  private Long totalPrice;

  public String getReceiver() {
    return receiver;
  }

  public String getAddress() {
    return address;
  }

  public String getMessage() {
    return message;
  }

  public Long getProductId() {
    return productId;
  }

  public Long getVolume() {
    return volume;
  }

  public Long getTotalPrice() {
    return totalPrice;
  }

  public OrderRequestDto() {
  }

  public OrderRequestDto(String receiver, String address, String message,
                         Long productId, Long volume, Long totalPrice) {
    this.receiver = receiver;
    this.address = address;
    this.message = message;
    this.productId = productId;
    this.volume = volume;
    this.totalPrice = totalPrice;
  }
}
