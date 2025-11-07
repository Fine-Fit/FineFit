package com.finefit.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finefit.domain.model.type.TokenType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private final JwtUtil jwtUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    log.info("request uri >>> {}", request.getRequestURI());

    // 인증이 필요없는 경로 토큰 검증 제외
    if (isExcludedPath(request.getRequestURI())) {
      log.info("토큰 검증 제외 경로");
      filterChain.doFilter(request, response);
      return;
    }

    // Header에서 Access-Token 추출
    String tokenHeader = request.getHeader(TokenType.ACCESS.getValue());

    // Bearer 시작 여부 및 null 값 검증
    if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
      log.info("유효하지 않은 토큰 값");
      tokenInvalid(response);
      return;
    }

    String accessToken = tokenHeader.substring(7);

    // Access-Token 만료시간 검증
    if (jwtUtil.isExpired(accessToken)) {
      log.info("Access 토큰 만료");
      tokenExpired(response);
      return;
    }

    setAuthentication(request);
    filterChain.doFilter(request, response);
  }

  // userId를 추출 및 인증 정보를 설정
  private void setAuthentication(HttpServletRequest request) {
    Long userId = jwtUtil.getUserId(request);

    Authentication authentication = jwtUtil.getAuthentication(userId.toString());
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

  private void tokenInvalid(HttpServletResponse response) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");


    Map<String, String> body = Map.of("message", "토큰값이 null 입니다.");
    response.getWriter().write(objectMapper.writeValueAsString(body));
  }

  // Access-Token 만료시 401 반환
  private void tokenExpired(HttpServletResponse response) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");


    Map<String, String> body = Map.of("message", "access-token 만료");
    response.getWriter().write(objectMapper.writeValueAsString(body));
  }

  // Jwt 검증 제외 경로
  private boolean isExcludedPath(String requestURI) {
    return requestURI.equals("/")
        || requestURI.matches("/v3/api-docs/.*")
        || requestURI.matches("/v3/api-docs")
        || requestURI.matches("/swagger-ui/.*")
        || requestURI.equals("/swagger-ui.html")
        || requestURI.matches("/swagger-resources/.*")
        || requestURI.startsWith("/admin")
        || requestURI.startsWith("/counsel")
        || requestURI.startsWith("/user");
  }
}