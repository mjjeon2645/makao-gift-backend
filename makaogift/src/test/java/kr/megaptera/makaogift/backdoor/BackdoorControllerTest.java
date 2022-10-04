package kr.megaptera.makaogift.backdoor;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BackdoorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void resetUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/reset-user"))
        .andExpect(status().isOk());
  }

  @Test
  void setupUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/backdoor/setup-user"))
        .andExpect(status().isOk());
  }
}