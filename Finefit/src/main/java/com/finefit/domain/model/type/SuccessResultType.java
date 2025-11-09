package com.finefit.domain.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessResultType {
  SUCCESS_ADMIN_REGISTER(HttpStatus.OK, "관리자 회원가입 요청 성공"),
  SUCCESS_VALIDATE_ID(HttpStatus.OK, "아이디 중복 체크 성공"),
  SUCCESS_ADMIN_LOGIN(HttpStatus.OK, "관리자 로그인 성공"),
  SUCCESS_GET_USER_INFO(HttpStatus.OK, "사용자 정보 조회 성공"),
  SUCCESS_GET_APPROVAL_USERS(HttpStatus.OK, "회원 승인 목록 조회 성공"),
  SUCCESS_UPDATE_USER_APPROVAL(HttpStatus.OK, "회원 승인 상태 변경 성공"),
  SUCCESS_GET_COUNSEL_LIST(HttpStatus.OK, "설문지 조회 성공"),
  SUCCESS_GET_COUNSEL_DETAILS(HttpStatus.OK, "설문지 상세 조회 성공"),
  SUCCESS_REQUEST_COUNSEL(HttpStatus.OK, "설문지 작성 성공"),
  ;

  private final HttpStatus status;
  private final String message;
}
