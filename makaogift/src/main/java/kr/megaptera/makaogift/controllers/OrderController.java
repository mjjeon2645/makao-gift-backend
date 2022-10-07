package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
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
    return orderService.order(sender, orderRequestDto);
  }

  @ExceptionHandler(LowAmountError.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String lowAmountError() {
    return "❌잔액이 부족하여 선물하기가 불가합니다❌";
  }
}
