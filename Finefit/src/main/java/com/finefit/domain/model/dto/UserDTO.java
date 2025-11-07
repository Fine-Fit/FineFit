package com.finefit.domain.model.dto;

import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.type.RoleType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {

  private String trainerId;

  private String trainerName;

  private String connect;

  private RoleType role;

  private String storeNumber;

  private String team;

  public static UserDTO toUserDTO(UserEntity user) {
    return UserDTO.builder()
        .trainerId(user.getTrainerId())
        .trainerName(user.getTrainerName())
        .connect(user.getConnect())
        .role(user.getRole())
        .storeNumber(user.getStoreNumber())
        .team(user.getTeam())
        .build();
  }

}
