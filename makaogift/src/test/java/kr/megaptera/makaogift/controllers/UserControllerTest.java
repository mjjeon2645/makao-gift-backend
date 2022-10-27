package kr.megaptera.makaogift.controllers;

import kr.megaptera.makaogift.models.*;
import kr.megaptera.makaogift.repositories.*;
import kr.megaptera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Test
  void registerSuccess() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"name\":\"전민지\"," +
                "\"userId\":\"mjjeon1234\"," +
                "\"password\":\"123qweQWE$\"," +
                "\"checkPassword\":\"123qweQWE$\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("\"amount\":")
        ));

    verify(userRepository).save(any());
  }

  @Test
  void registerFailWithDuplicatedId() throws Exception {
    given(userRepository.findByUserId("mjjeon1234"))
        .willReturn(Optional.of(new User()));

    mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"name\":\"전민지\"," +
                "\"userId\":\"mjjeon1234\"," +
                "\"password\":\"123qweQWE$\"," +
                "\"checkPassword\":\"123qweQWE$\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }

  @Test
  void registerFailWithIncorrectCheckPassword() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"name\":\"전민지\"," +
                "\"userId\":\"mjjeon1234\"," +
                "\"password\":\"123qweQWE$\"," +
                "\"checkPassword\":\"123qweQWE$!!\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }
}
