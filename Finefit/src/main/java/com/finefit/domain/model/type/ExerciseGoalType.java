package com.finefit.domain.model.type;

import lombok.Getter;

/** 운동 목적 */

@Getter
public enum ExerciseGoalType {

  WEIGHT_LOSS("체중 감량 / 다이어트"),
  WEIGHT_GAIN("체중 증가 / 벌크업"),
  POSTURE_CORRECTION("체형 교정"),
  STRENGTH_INCREASE("근력 향상"),
  HEALTH_MANAGEMENT("건강 관리 / 체력 증가"),
  PAIN_RELIEF("통증 개선"),
  POSTURE_ADJUSTMENT("자세 교정"),
  ETC("기타");

  private final String description;

  ExerciseGoalType(String description) {
    this.description = description;
  }

}
