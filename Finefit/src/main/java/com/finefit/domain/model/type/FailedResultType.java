package com.finefit.domain.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FailedResultType {
  FAILED_USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않은 사용자 입니다."),
  FAILED_PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
  FAILED_ACCESS_PENDING(HttpStatus.BAD_REQUEST, "승인 대기중 입니다."),
  FAILED_ACCESS_REJECTED(HttpStatus.BAD_REQUEST, "승인 거절 되었습니다."),
  FAILED_COUNSEL_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 설문지를 찾을 수 없습니다."),

  FAILED_ACCESS_DENIED(HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),
  ;

  private final HttpStatus status;
  private final String message;
}
