package kr.megaptera.makaogift.services;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

import java.time.*;
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
    Sort sort = Sort.by("createdAt").descending();
    int page = 1;
    Pageable pageable = PageRequest.of(page - 1, 8, sort);
    List<OrderHistory> orderHistories = List.of(
        new OrderHistory(1L, "mjjeon2645", "아이폰14", "애플", 1L, 500000L,
            LocalDateTime.of(2022, 10, 6, 11, 3, 14, 0), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl"),
        new OrderHistory(2L, "mjjeon2645", "컴포즈커피", "컴포즈커피", 1L, 3500L,
            LocalDateTime.of(2022, 10, 7, 11, 3, 14, 0), "전민지", "서울시 강남구", "맛있게 마셔~!", "imgUrl"),
        new OrderHistory(3L, "mjjeon2645", "보냉백", "따뜻한나라", 2L, 15000L,
            LocalDateTime.of(2022, 10, 8, 11, 3, 14, 0), "몽몽이", "경남 울산", "필요하다고 했지?", "imgUrl"));

    given(orderHistoryService.histories(sender, page))
        .willReturn(new PageImpl<>(orderHistories, pageable, orderHistories.size()));

    Long historyId = 1L;

    given(orderHistoryRepository.findById(historyId))
        .willReturn(Optional.of(new OrderHistory(1L, "mjjeon2645", "아이폰14", "애플", 1L, 500000L,
            LocalDateTime.of(2022, 10, 10, 11, 3, 14, 0), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl")));
  }

  @Test
  void histories() {
    String sender = "mjjeon2645";
    int page = 1;
    Page<OrderHistory> orderHistories = orderHistoryService.histories(sender, page);

    assertThat(orderHistories).hasSize(3);
    verify(orderHistoryRepository).findAllBySender(any(), any());
  }

  @Test
  void detailWithCorrectHistoriesId() {
    Long id = 1L;
    OrderHistory orderHistory = orderHistoryService.detail(id);
    assertThat(orderHistory).isNotNull();
    assertThat(orderHistory.productName()).isEqualTo("아이폰14");
  }

  @Test
  void detailWithIncorrectHistoriesId() {
    assertThrows(OrderHistoryNotFound.class, () -> {
        orderHistoryService.detail(2L);
    });
  }
}
