package com.finefit.domain.model.type;

import lombok.Getter;

/** 운동 선호 스타일 */

@Getter
public enum ExerciseStyleType {

  DETAILED_POSTURE("꼼꼼한 자세 교정"),
  HIGH_INTENSITY("땀나는 고강도 운동"),
  FUN_AND_LIGHT("재밌고 가벼운 운동"),
  CUSTOMIZED("목적에 따라 맞춤 조절");

  private final String description;

  ExerciseStyleType(String description) {
    this.description = description;
  }

}
