package kr.megaptera.makaogift.interceptors;

import com.auth0.jwt.exceptions.*;
import kr.megaptera.makaogift.exceptions.*;
import kr.megaptera.makaogift.utils.*;
import org.springframework.web.servlet.*;

import javax.servlet.http.*;

public class AuthenticationInterceptor implements HandlerInterceptor {
  private final JwtUtil jwtUtil;

  public AuthenticationInterceptor(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) throws Exception {

    String authorization = request.getHeader("Authorization");

    if (authorization == null || !authorization.startsWith("Bearer ")) {
      // 토큰 들어온게 없음
      return true;
    }

    String token = authorization.substring("Bearer ".length());

    try {
      String userId = jwtUtil.decode(token);

      request.setAttribute("userId", userId);

      return true;
    } catch (JWTDecodeException exception) {
      throw new AuthenticationError();
    }
  }
}
