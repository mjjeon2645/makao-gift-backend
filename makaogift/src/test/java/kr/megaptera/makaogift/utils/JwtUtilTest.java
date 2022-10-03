package kr.megaptera.makaogift.utils;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

  static final String SECRET = "SECRET";
  private JwtUtil jwtUtil;

  @BeforeEach
  void setUp() {
    jwtUtil = new JwtUtil(SECRET);
  }

  @Test
  void encodeAndDecode() {
    String original = "mjjeon2645";

    String token = jwtUtil.encode(original);

    String userId = jwtUtil.decode(token);

    assertThat(userId).isEqualTo(original);
  }

//  @Test
//  void decodeError() {
//   jwtUtil.decode("xxx");
//  }
}
