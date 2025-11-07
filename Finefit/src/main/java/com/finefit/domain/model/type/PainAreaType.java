package com.finefit.domain.model.type;

import lombok.Getter;


/** 통증 부위 */

@Getter
public enum PainAreaType {
  SHOULDER("어깨"),
  KNEE("무릎"),
  WAIST("허리"),
  NECK("목"),
  ETC("기타");

  private final String description;

  PainAreaType(String description) {
    this.description = description;
  }

}
