package com.finefit.domain.model.type;

import lombok.Getter;

@Getter
public enum RoleType {
  CEO("대표", 6),
  DIRECTOR("이사", 5),
  EXECUTIVE("실장", 4),
  MANAGER("매니저", 3),
  TEAM_LEADER("팀장", 2),
  TRAINER("트레이너", 1);

  private final String description;
  private final int level;

  RoleType(String description, int level) {
    this.description = description;
    this.level = level;
  }

  public static boolean isAboveOrEqual(RoleType userRole, RoleType requiredRole) {
    return userRole.level >= requiredRole.level;
  }
}
