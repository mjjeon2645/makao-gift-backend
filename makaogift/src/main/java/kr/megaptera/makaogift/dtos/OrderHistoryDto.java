package kr.megaptera.makaogift.dtos;

public class OrderHistoryDto {
  private Long id;
  private String productName;
  private String manufacturer;
  private Long volume;
  private Long totalPrice;
  private String orderedDate;
  private String receiver;
  private String address;
  private String message;
  private String imgSource;

  public OrderHistoryDto() {
  }

  public OrderHistoryDto(Long id, String productName, String manufacturer, Long volume,
                         Long totalPrice, String orderedDate, String receiver,
                         String address, String message, String imgSource) {
    this.id = id;
    this.productName = productName;
    this.manufacturer = manufacturer;
    this.volume = volume;
    this.totalPrice = totalPrice;
    this.orderedDate = orderedDate;
    this.receiver = receiver;
    this.address = address;
    this.message = message;
    this.imgSource = imgSource;
  }

  public Long getId() {
    return id;
  }

  public String getProductName() {
    return productName;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public Long getVolume() {
    return volume;
  }

  public Long getTotalPrice() {
    return totalPrice;
  }

  public String getOrderedDate() {
    return orderedDate;
  }

  public String getReceiver() {
    return receiver;
  }

  public String getAddress() {
    return address;
  }

  public String getMessage() {
    return message;
  }

  public String getImgSource() {
    return imgSource;
  }
}
