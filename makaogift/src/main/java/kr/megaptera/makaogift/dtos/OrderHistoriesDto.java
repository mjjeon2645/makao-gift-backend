package kr.megaptera.makaogift.dtos;

import java.util.*;

public class OrderHistoriesDto {
  private List<OrderHistoryDto> orderHistories;

  public OrderHistoriesDto(List<OrderHistoryDto> orderHistoryDtos) {
    this.orderHistories = orderHistoryDtos;
  }

  public List<OrderHistoryDto> getOrderHistories() {
    return orderHistories;
  }
}
