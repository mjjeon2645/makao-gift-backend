package kr.megaptera.makaogift.dtos;

public class ProductDto {
  private Long id;
  private String name;
  private Long price;
  private String manufacturer;
  private String description;
  private String imgSource;

  public ProductDto() {
  }

  public ProductDto(Long id, String name, Long price, String manufacturer, String description, String imgSource) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.manufacturer = manufacturer;
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public String getImgSource() {
    return imgSource;
  }
}
