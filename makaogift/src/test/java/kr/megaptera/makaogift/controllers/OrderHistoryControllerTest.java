package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import kr.megaptera.makaogift.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.time.*;
import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderHistoryController.class)
class OrderHistoryControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OrderHistoryService orderHistoryService;

  @SpyBean
  private JwtUtil jwtUtil;

  @BeforeEach
  void setUp() {
    String sender = "mjjeon2645";
    Sort sort = Sort.by("createdAt").descending();
    int page = 1;
    Pageable pageable = PageRequest.of(page - 1, 8, sort);
    List<OrderHistory> orderHistories = List.of(
        new OrderHistory(1L, "mjjeon2645", "아이폰14", "애플", 1L, 500000L,
            LocalDateTime.of(2022, 10, 3, 11, 3, 14, 0), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl"),
        new OrderHistory(2L, "mjjeon2645", "컴포즈커피", "컴포즈커피", 1L, 3500L,
            LocalDateTime.of(2022, 10, 4, 11, 3, 14, 0), "전민지", "서울시 강남구", "맛있게 마셔~!", "imgUrl"),
        new OrderHistory(3L, "mjjeon2645", "보냉백", "따뜻한나라", 2L, 15000L,
            LocalDateTime.of(2022, 10, 7, 11, 3, 14, 0), "몽몽이", "경남 울산", "필요하다고 했지?", "imgUrl"));

    given(orderHistoryService.histories(sender, page))
        .willReturn(new PageImpl<>(orderHistories, pageable, orderHistories.size()));

    Long id = 1L;
    given(orderHistoryService.detail(id))
        .willReturn(
            new OrderHistory(1L, "mjjeon2645", "아이폰14", "애플", 1L, 500000L,
                LocalDateTime.of(2022, 10, 3, 11, 3, 14, 0), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl"));
  }

  @Test
  void histories() throws Exception {
    String accessToken = jwtUtil.encode("mjjeon2645");
    mockMvc.perform(MockMvcRequestBuilders.get("/orders")
            .header("Authorization", "Bearer " + accessToken))
        .andExpect(status().isOk());
  }

  @Test
  void detail() throws Exception {
    String accessToken = jwtUtil.encode("mjjeon2645");
    mockMvc.perform(MockMvcRequestBuilders.get("/orders/1")
            .header("Authorization", "Bearer " + accessToken)
            .param("id", "1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("\"totalPrice\":50000")
        ));
  }
}
