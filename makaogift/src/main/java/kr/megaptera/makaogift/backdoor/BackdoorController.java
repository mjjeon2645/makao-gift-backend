package kr.megaptera.makaogift.backdoor;

import org.springframework.jdbc.core.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("backdoor")
@Transactional
public class BackdoorController {
  private JdbcTemplate jdbcTemplate;

  public BackdoorController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @GetMapping("reset-user")
  public String resetUser() {
    // 1. 기존 데이터를 리셋한다
    jdbcTemplate.execute("DELETE FROM person");

    return "OK";
  }

  @GetMapping("setup-user")
  public String setupUser() {
    // 1. 기존 데이터를 리셋한다
    jdbcTemplate.execute("DELETE FROM person");

    // 2. 원하는 데이터를 세팅한다. (예. user 정보를 아래와 같이)
    jdbcTemplate.execute("INSERT INTO person" +
        "(id, name, user_id, encoded_password, amount) " +
        "VALUES(1, '전민지', 'mjjeon2645', " +
        "'$argon2id$v=19$m=4096,t=3,p=1$2jFzUQ1q1BiGnXKc7Uyuhg$rnEJqCr" +
        "/rRkVrT3nWxz7ul31KaJQ2pDneic52QgG/UU', 50000)");

    return "OK";
  }

  @GetMapping("reset-products")
  public String resetProducts() {
    // 1. 기존 데이터를 리셋한다
    jdbcTemplate.execute("DELETE FROM product");

    return "OK";
  }

  @GetMapping("setup-three-products")
  public String setupThreeProducts() {
    jdbcTemplate.execute("DELETE FROM product");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(1, '누구나 좋아하는 지방시 선물세트', 10000, 'GIVENCHY', " +
        "'지방시 선물세트 누구나 다 좋아합니다', 'imgSource')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(2, '새로나온 아이폰 14', 45000, '애플', " +
        "'아이폰 14 싸다', 'imgSource')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(3, '맛있는 상주곶감', 30000, '상주농협', " +
        "'어른분들께 선물로 드리기 좋아요', 'imgSource')");

    return "ok";
  }
}
