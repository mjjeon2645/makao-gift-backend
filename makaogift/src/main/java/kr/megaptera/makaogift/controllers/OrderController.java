package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
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
      @Validated @RequestBody OrderRequestDto orderRequestDto
  ) {
    return orderService.order(sender, orderRequestDto);
  }

  @ExceptionHandler(LowBalanceError.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto lowBalanceError() {
    return new LowBalanceErrorDto();
  }
}
