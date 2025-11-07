package com.finefit.domain.model.type;

import lombok.Getter;

@Getter
public enum ApprovalStatusType {
  PENDING("승인 대기"),
  APPROVED("승인 완료"),
  REJECTED("승인 거부");

  private final String description;

  ApprovalStatusType(String description) {
    this.description = description;
  }

  public static boolean isApproved(ApprovalStatusType approvalStatusType) {
    return ApprovalStatusType.APPROVED.equals(approvalStatusType);
  }
}
