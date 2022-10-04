package kr.megaptera.makaogift.models;

import kr.megaptera.makaogift.dtos.*;

import javax.persistence.*;

@Entity
public class Product {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private Long price;

  private String manufacturer;

  private String description;

  private String imgSource;

  public Product() {
  }

  public Product(Long id, String name, Long price, String manufacturer,
                 String description, String imgSource) {
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

  public ProductDto toProductDto() {
    return new ProductDto(id, name, price, manufacturer, imgSource);
  }
}
