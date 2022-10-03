package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SessionController.class)
@ActiveProfiles("test")
class SessionControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private LoginService loginService;

  @BeforeEach
  void setUp() {
    given(loginService.login("mjjeon2645", "test"))
        .willReturn(User.fake("mjjeon2645"));

    given(loginService.login("mjjeon2645111", "test"))
        .willThrow(new LoginFailed());

    given(loginService.login("mjjeon2645", "test111"))
        .willThrow(new LoginFailed());
  }

  @Test
  void login() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"mjjeon2645\"," +
                "\"password\":\"test\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("\"amount\":")
        ));
  }

  @Test
  void loginFailedWithIncorrectUserId() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"mjjeon2645111\"," +
                "\"password\":\"test\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }

  @Test
  void loginFailedWithIncorrectPassword() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"mjjeon2645\"," +
                "\"password\":\"test111\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }
}
