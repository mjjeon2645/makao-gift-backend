package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)

  public OrderResultDto order(
      @RequestAttribute("userId") String sender,
      @RequestBody OrderRequestDto orderRequestDto
  ) {
    orderService.order(sender, orderRequestDto);

    return new OrderResultDto();
  }
}
