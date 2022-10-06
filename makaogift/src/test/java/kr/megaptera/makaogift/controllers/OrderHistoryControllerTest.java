package kr.megaptera.makaogift.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderHistoryController.class)
class OrderHistoryControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void list() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/orders"))
        .andExpect(status().isOk());
  }
}
