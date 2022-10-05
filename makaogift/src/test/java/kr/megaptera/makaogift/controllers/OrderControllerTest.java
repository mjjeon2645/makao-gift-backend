package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.services.*;
import kr.megaptera.makaogift.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
@ActiveProfiles("test")
class OrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OrderService orderService;

  @SpyBean
  private JwtUtil jwtUtil;

  @Test
  void order() throws Exception {

    String accessToken = jwtUtil.encode("mjjeon2645");

    mockMvc.perform(MockMvcRequestBuilders.post("/order")
            .header("Authorization", "Bearer " + accessToken)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"receiver\":\"이서진\", \"address\":\"서울시 양천구\", " +
                "\"message\":\"서진아 생일축하해~\", \"productId\":2, \"volume\":1, " +
                "\"totalPrice\":10000}"))
        .andExpect(status().isCreated());
  }
}
