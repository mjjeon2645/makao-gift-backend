package kr.megaptera.makaogift.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SessionController.class)
@ActiveProfiles("test")
class SessionControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void login() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"mjjeon2645\"," +
                "\"password\":\"123!@#qweQWE\"" +
                "}"))
        .andExpect(status().isCreated());
  }

  @Test
  void loginFailedWithIncorrectPassword() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"mjjeon2645\"," +
                "\"password\":\"123!@#qweQWE!\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }
}
