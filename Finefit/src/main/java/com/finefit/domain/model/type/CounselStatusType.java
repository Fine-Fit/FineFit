package com.finefit.domain.model.type;

import lombok.Getter;

@Getter
public enum CounselStatusType {

  WAITING("대기중"),
  COMPLETED("상담완료");

  private final String description;

  CounselStatusType(String description) {
    this.description = description;
  }
}
