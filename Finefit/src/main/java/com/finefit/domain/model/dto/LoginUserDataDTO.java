package com.finefit.domain.model.dto;

import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.type.RoleType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginUserDataDTO {

  private Long userId;

  private RoleType role;


  public static LoginUserDataDTO toLoginUserDataDTO(UserEntity user) {
    return LoginUserDataDTO.builder()
        .userId(user.getUserId())
        .role(user.getRole())
        .build();
  }
}
