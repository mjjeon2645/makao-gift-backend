package kr.megaptera.makaogift.dtos;

public class ProductDto {
  private Long id;
  private String name;
  private Long price;
  private String manufacturer;
  private String imgSource;

  public ProductDto() {
  }

  public ProductDto(Long id, String name, Long price, String manufacturer, String imgSource) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.manufacturer = manufacturer;
    this.imgSource = imgSource;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String getImgSource() {
    return imgSource;
  }
}
