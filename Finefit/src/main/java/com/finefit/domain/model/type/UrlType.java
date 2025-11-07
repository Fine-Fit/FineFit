package com.finefit.domain.model.type;

import lombok.Getter;

@Getter
public enum UrlType {
  // 프론트엔드 로컬 URL
  FRONT_LOCAL_URL("http://localhost:3000"),

  // 백엔드 로컬 URL
  BACK_LOCAL_URL("http://localhost:8080"),

  // 운영 서버 URL
  PROD_SERVER_URL("https://api.finefit.co.kr"),

  // Dear Birdy URL
  FINEFIT_URL("https://www.finefit.co.kr"),
  ;

  private final String url;

  UrlType(String value) {
    this.url = value;
  }
}

