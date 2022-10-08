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
  private final OrderHistoryService orderHistoryService;

  public OrderHistoryController(OrderHistoryService orderHistoryService) {
    this.orderHistoryService = orderHistoryService;
  }

  @GetMapping
  public OrderHistoriesDto histories(
      @RequestParam(required = false, defaultValue = "1") int page,
      @RequestAttribute("userId") String sender
  ) {

    List<OrderHistoryDto> orderHistories =
        orderHistoryService.histories(sender, page).stream().map(OrderHistory::toDto)
            .collect(Collectors.toList());

    int totalPageNumbers = orderHistoryService.getPages(sender);

    return new OrderHistoriesDto(orderHistories, totalPageNumbers);
  }

  @GetMapping("{id}")
  public OrderHistoryDto detail(
      @PathVariable("id") Long id
  ) {
    OrderHistory orderHistory = orderHistoryService.detail(id);

    return orderHistory.toDto();
  }
}
