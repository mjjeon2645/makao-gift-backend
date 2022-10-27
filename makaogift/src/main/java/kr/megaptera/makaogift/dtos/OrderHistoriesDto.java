package kr.megaptera.makaogift.dtos;

import java.util.*;

public class OrderHistoriesDto {
  private List<OrderHistoryDto> orderHistories;
  private int totalPageNumbers;

  public OrderHistoriesDto(List<OrderHistoryDto> orderHistoryDtos, int totalPageNumbers) {
    this.orderHistories = orderHistoryDtos;
    this.totalPageNumbers = totalPageNumbers;
  }

  public List<OrderHistoryDto> getOrderHistories() {
    return orderHistories;
  }

  public int getTotalPageNumbers() {
    return totalPageNumbers;
  }
}
