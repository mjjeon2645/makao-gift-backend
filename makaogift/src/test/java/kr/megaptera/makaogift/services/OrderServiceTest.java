package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.dtos.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderServiceTest {
  private OrderService orderService;
  private OrderHistoryRepository orderHistoryRepository;
  private UserRepository userRepository;
  private ProductRepository productRepository;

  @BeforeEach
  void setUp() {
    orderHistoryRepository = mock(OrderHistoryRepository.class);

    userRepository = mock(UserRepository.class);

    productRepository = mock(ProductRepository.class);

    orderService = new OrderService(orderHistoryRepository, userRepository,
        productRepository);

    String sender = "mjjeon2645";

    given(userRepository.findByUserId(sender)).willReturn(Optional.of(User.fake(sender)));
    given(productRepository.getReferenceById(any()))
        .willReturn(new Product(2L, "새로나온 아이폰14", 10_000L, "애플", "아이폰 14 싸다", "imgUrl"));
  }

  @Test
  void order() {
    // 1. order 서비스는 총 금액에 따라 sender의 amount를 차감해야 함. 해결.
    // 2. order 서비스는 order history를 생성해야 함

    String sender = "mjjeon2645";

    User user = userRepository.findByUserId(sender)
        .orElseThrow(() -> new AuthenticationError());

    OrderRequestDto orderRequestDto = new OrderRequestDto(
        "이서진", "서울시 양천구", "서진아 생일축하해~", 2L, 1L, 10_000L);

    orderService.order(sender, orderRequestDto);

    assertThat(user.amount()).isEqualTo(40_000L);
    verify(orderHistoryRepository).save(any());
  }
}
