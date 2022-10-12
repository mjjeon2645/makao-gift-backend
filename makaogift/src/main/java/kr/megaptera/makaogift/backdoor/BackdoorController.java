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
        "'지방시 선물세트 누구나 다 좋아합니다', " +
        "'https://user-images.githubusercontent.com/104840243/194968445-034616c3-7ec9-46ec-8601-87ffb2239d4d.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(2, '새로나온 아이폰 14', 55000, '애플', " +
        "'아이폰 14 싸다', " +
        "'https://user-images.githubusercontent.com/104840243/194969244-b2b64351-0a5e-429d-882b-e27a99ca2b73.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(3, '맛있는 상주곶감', 30000, '상주농협', " +
        "'어른분들께 선물로 드리기 좋아요', " +
        "'https://user-images.githubusercontent.com/104840243/194969313-7aecf0b3-43b0-41a1-bc2f-4dee9472f67a.png')");

    return "ok";
  }

  @GetMapping("setup-eighteen-products")
  public String setupEighteenProducts() {
    jdbcTemplate.execute("DELETE FROM product");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(1, '누구나 좋아하는 지방시 선물세트', 10000, 'GIVENCHY', " +
        "'지방시 선물세트 누구나 다 좋아합니다', " +
        "'https://user-images.githubusercontent.com/104840243/194968445-034616c3-7ec9-46ec-8601-87ffb2239d4d.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(2, '새로나온 아이폰 14', 45000, '애플', " +
        "'아이폰 14 싸다', " +
        "'https://user-images.githubusercontent.com/104840243/194969244-b2b64351-0a5e-429d-882b-e27a99ca2b73.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(3, '맛있는 상주곶감', 30000, '상주농협', " +
        "'어른분들께 선물로 드리기 좋아요', " +
        "'https://user-images.githubusercontent.com/104840243/194969313-7aecf0b3-43b0-41a1-bc2f-4dee9472f67a.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(4, '씨스루 프로틴워터 애플', 29800, '이롬', " +
        "'가을이라고 다이어트를 멈출순 없지!', " +
        "'https://user-images.githubusercontent.com/104840243/194735391-71ee45ba-cf54-473c-8c74-9a6ee2985979.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(5, '진생 로얄실크 워터리 크림', 93600, '네이처리퍼블릭', " +
        "'몸에 좋은 인삼 이제는 피부에 양보하세요', " +
        "'https://user-images.githubusercontent.com/104840243/194968555-a32d1632-b038-47b5-bfcf-f35b8862cc7c.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(6, '비오틴 L시스틴 맥주효모 영양제', 27000, 'PH365', " +
        "'활력있는 당신을 위해 오늘도 풍성하게! 프리미엄 비오틴 4중 복합 기능성', " +
        "'https://user-images.githubusercontent.com/104840243/194968642-3cf29ad0-ee82-40ba-97d9-f4f90048ba33.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(7, '카누 티라미수 라떼 24개입', 8080, '동서식품', " +
        "'공유 얼굴도 보고 힐링도 하고 커피도 마시고', " +
        "'https://user-images.githubusercontent.com/104840243/194968711-dd602c74-fcef-43fd-bd31-b31a3c1ff244.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(8, '여행용 투명 수영가방', 3780, '래빗', " +
        "'아이들 소풍갈 때 선물하기 좋아요!', " +
        "'https://user-images.githubusercontent.com/104840243/194968772-927f47f9-46f8-44a4-ba13-296e0eaa40dd.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(9, '맨백 USB 노트북 백팩', 20750, '백앤백즈', " +
        "'무겁게 들고 다니지 말고 이제는 메고 다니자!', " +
        "'https://user-images.githubusercontent.com/104840243/194968830-687f27a8-507b-40af-bfa8-4c5792bdab92.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(10, '블루밍 여행용 캐리어', 33110, '코리아캐리어', " +
        "'코로나 제한 완화!! 이제 외국으로 나가보는거야!', " +
        "'https://user-images.githubusercontent.com/104840243/194968872-65c3d00e-3d9e-44a9-b6e3-5eb3eefeaa61.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(11, '사니젠 겔 99.9% 살균 보장', 4890, '월드켐', " +
        "'아직 코로나는 끝나지 않았다. 끈적이지 않는 산뜻한 손소독겔 대용량', " +
        "'https://user-images.githubusercontent.com/104840243/194968918-fa868860-7b3a-461c-aa79-6f7f62ec0c06.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(12, '다시 다음으로! 더이상은 네이버!!', 100, 'DAUM', " +
        "'카카오와 함께 다시 날아오르는 다음~~~~~', " +
        "'https://user-images.githubusercontent.com/104840243/194968957-96b07663-043c-4d2d-8d83-e245d405795f.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(13, '아이폰14 방탄유리 보호필름', 16800, '케이맥스', " +
        "'아이폰 사셨나요? 미리미리 준비합시다~', " +
        "'https://user-images.githubusercontent.com/104840243/194969027-61c1187f-beeb-4f96-a665-c6460e803f50.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(14, '숙성 한우 선물세트', 12500, '우리농산물집', " +
        "'우리 한우가 최고! 입에서 살살 녹는 한우 선물세트', " +
        "'https://user-images.githubusercontent.com/104840243/194969117-74a923f0-6fdf-4cf6-9112-771e22106524.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(15, '광동 비타오백 물세트', 32900, '광동', " +
        "'비타오백 선물세트로 오늘 하루도 기운 충전!', " +
        "'https://user-images.githubusercontent.com/104840243/194969188-9ba06113-07a5-45c9-b009-01d146efb01a.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(16, '고디바 마스터피스 초콜릿', 28900, 'GODIVA', " +
        "'말 안해도 아시져? 초콜릿계의 에르메스 고디바', " +
        "'https://user-images.githubusercontent.com/104840243/194969382-6e127b92-32ed-4cb1-b1b8-7407ca3c5f43.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(17, '투썸플레이스 아메리카노', 4900, '투썸플레이스', " +
        "'따뜻한 커피 한잔으로 마음을 전하세요', " +
        "'https://user-images.githubusercontent.com/104840243/194969483-7cbd463a-7b8a-4a4f-841a-53c833f27472.png')");

    jdbcTemplate.execute("INSERT INTO product" +
        "(id, name, price, manufacturer, description, img_source) " +
        "VALUES(18, '갤럭시 Z-fold Z-flip', 1900000, '삼성', " +
        "'수능보는 친구들에게 거하게 한 턱 쏘세요!', " +
        "'https://user-images.githubusercontent.com/104840243/194969576-716adefc-d106-49cc-b13d-86cc1011fd14.png')");

    return "ok";
  }

  @GetMapping("reset-order-histories")
  public String resetOrderHistories() {
    // 1. 기존 주문 히스토리 데이터를 리셋한다
    jdbcTemplate.execute("DELETE FROM order_history");

    return "OK";
  }

  @GetMapping("setup-two-histories")
  public String setupTwoHistories() {
    jdbcTemplate.execute("DELETE FROM order_history");

    jdbcTemplate.execute("INSERT INTO order_history" +
        "(id, sender, product_name, manufacturer, volume, total_price, " +
        "created_at, receiver, address, message, img_source) " +
        "VALUES(1, 'mjjeon2645', '누구나 좋아하는 지방시 선물세트', 'GIVENCHY', 1, 10000, " +
        "'2022-10-12 09:41:16.437382', '이서진', '서울시 양천구', '서진아 생일축하해~', " +
        "'https://user-images.githubusercontent.com/104840243/194968445-034616c3-7ec9-46ec-8601-87ffb2239d4d.png')");

    jdbcTemplate.execute("INSERT INTO order_history" +
        "(id, sender, product_name, manufacturer, volume, total_price, " +
        "created_at, receiver, address, message, img_source) " +
        "VALUES(2, 'mjjeon2645', '새로나온 아이폰 14', '애플', 1, 55000, " +
        "'2022-10-13 09:41:16.437382', '이상균', '서울시 양천구', '상균아 잘 써!', " +
        "'https://user-images.githubusercontent.com/104840243/194969244-b2b64351-0a5e-429d-882b-e27a99ca2b73.png')");

    return "ok";
  }
}
