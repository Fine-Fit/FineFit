package com.finefit.domain.model.type;


import lombok.Getter;

/** 운동 종류 */

@Getter
public enum ExerciseType {
  GYM("헬스장 운동"),
  CARDIO("유산소 운동"),
  HOME_TRAINING("홈트레이닝"),
  PILATES_YOGA("필라테스 / 요가"),
  MARTIAL_ARTS_CROSSFIT("격투기 / 크로스핏 등"),
  ETC("기타");

  private final String description;

  ExerciseType(String description) {
    this.description = description;
  }

}
