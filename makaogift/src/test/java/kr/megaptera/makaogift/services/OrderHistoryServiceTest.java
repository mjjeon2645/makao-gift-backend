package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

class OrderHistoryServiceTest {
  private OrderHistoryService orderHistoryService;
  private OrderHistoryRepository orderHistoryRepository;

  @BeforeEach
  void setUp() {
    orderHistoryRepository = mock(OrderHistoryRepository.class);

    orderHistoryService = new OrderHistoryService(orderHistoryRepository);

    String sender = "mjjeon2645";

    given(orderHistoryRepository.findAllBySender(sender)).willReturn(List.of(
        new OrderHistory(1L, "mjjeon2645", "아이폰14", "애플", 1L, 500000L,
            any(), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl")
    ));

    given(orderHistoryRepository.findById(2L)).willReturn(
        Optional.of(new OrderHistory(1L, "mjjeon2645f", "아이폰14", "애플", 1L, 500000L,
        any(), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl")));
  }

  @Test
  void histories() {
    String userId = "mjjeon2645";
    List<OrderHistory> orderHistories = orderHistoryService.histories(userId);

    assertThat(orderHistories).hasSize(1);
    assertThat(orderHistories.get(0)).isNotNull();
    verify(orderHistoryRepository).findAllBySender(any());
  }

  @Test
  void detail() {
    Long id = 2L;

    OrderHistory orderHistory = orderHistoryService.detail(id);

    assertThat(orderHistory).isNotNull();
  }
}