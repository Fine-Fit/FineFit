package com.finefit.domain.model.type;


import lombok.Getter;

/** 성별 */

@Getter
public enum GenderType {

  MALE("남성"),
  FEMALE("여성"),
  OTHER("기타");

  private final String description;

  GenderType(String description) {
    this.description = description;
  }

}
