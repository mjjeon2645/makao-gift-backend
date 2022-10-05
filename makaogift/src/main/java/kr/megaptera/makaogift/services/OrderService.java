package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class OrderService {
  private final OrderHistoryRepository orderHistoryRepository;
  private final UserRepository userRepository;
  private final ProductRepository productRepository;

  public OrderService(OrderHistoryRepository orderHistoryRepository,
                      UserRepository userRepository,
                      ProductRepository productRepository) {
    this.orderHistoryRepository = orderHistoryRepository;
    this.userRepository = userRepository;
    this.productRepository = productRepository;
  }

  public void order(String sender, OrderRequestDto orderRequestDto) {
    // 1. order 서비스는 총 금액에 따라 sender의 amount를 차감해야 함
    User user = userRepository.findByUserId(sender)
        .orElseThrow(() -> new AuthenticationError());

    user.pay(orderRequestDto.getTotalPrice());

    // 2. order 서비스는 orderHistory를 생성해야 함
    String productName = productRepository
        .getReferenceById(orderRequestDto.getProductId())
        .getName();

    String manufacturer = productRepository
        .getReferenceById(orderRequestDto.getProductId())
        .getManufacturer();

    Long volume = orderRequestDto.getVolume();

    Long totalPrice = orderRequestDto.getTotalPrice();

    String receiver = orderRequestDto.getReceiver();

    String address = orderRequestDto.getAddress();

    String message = orderRequestDto.getMessage();

    OrderHistory orderHistory =
        new OrderHistory(sender, productName, manufacturer, volume, totalPrice,
            receiver, address, message);

    orderHistoryRepository.save(orderHistory);
  }
}
