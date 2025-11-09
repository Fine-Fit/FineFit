package com.finefit.domain.model.type;

import lombok.Getter;

/** 운동 빈도 */

@Getter
public enum ExerciseFrequencyType {

  NEVER("전혀 하지 않음"),
  SOMETIMES("가끔 (주 1~2회)"),
  REGULARLY("규칙적으로 (주 3회 이상)");

  private final String description;

  ExerciseFrequencyType(String description) {
    this.description = description;
  }

}
