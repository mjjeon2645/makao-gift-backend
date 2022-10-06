package kr.megaptera.makaogift.dtos;

import java.util.*;

public class OrderHistoriesDto {
  private List<OrderHistoryDto> orderHistoryDtos;

  public OrderHistoriesDto(List<OrderHistoryDto> orderHistoryDtos) {
    this.orderHistoryDtos = orderHistoryDtos;
  }

  public List<OrderHistoryDto> getOrderHistoryDtos() {
    return orderHistoryDtos;
  }
}
