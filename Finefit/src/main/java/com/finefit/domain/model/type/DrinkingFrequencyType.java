package com.finefit.domain.model.type;


import lombok.Getter;

/** 음주 빈도 */

@Getter
public enum DrinkingFrequencyType {

  RARELY("거의 안 함"),
  SOMETIMES("가끔 (주 1회 이하)"),
  OFTEN("자주 (주 2회 이상)");

  private final String description;

  DrinkingFrequencyType(String description) {
    this.description = description;
  }

}
