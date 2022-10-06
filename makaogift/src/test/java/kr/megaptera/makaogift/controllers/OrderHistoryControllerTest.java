package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import kr.megaptera.makaogift.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.stereotype.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.time.*;
import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    given(orderHistoryService.histories(sender)).willReturn(List.of(
        new OrderHistory(1L, "mjjeon2645", "아이폰14", "애플", 1L, 500000L,
            any(), "이서진", "서울시 동작구", "서진아 생일축하해!", "imgUrl")
    ));
  }

  @Test
  void list() throws Exception {
    String accessToken = jwtUtil.encode("mjjeon2645");
    mockMvc.perform(MockMvcRequestBuilders.get("/orders")
            .header("Authorization", "Bearer " + accessToken))
        .andExpect(status().isOk());
  }
}
