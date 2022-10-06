package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("orders")
public class OrderHistoryController {
  private OrderHistoryService orderHistoryService;

  public OrderHistoryController(OrderHistoryService orderHistoryService) {
    this.orderHistoryService = orderHistoryService;
  }

  @GetMapping
  public OrderHistoriesDto histories(
      @RequestAttribute("userId") String sender
  ) {
    List<OrderHistory> orderHistories = orderHistoryService.histories(sender);

    List<OrderHistoryDto> orderHistoryDtos =
        orderHistories.stream().map(OrderHistory::toDto).toList();

    return new OrderHistoriesDto(orderHistoryDtos);
  }
}
