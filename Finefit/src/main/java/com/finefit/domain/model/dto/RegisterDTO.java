package com.finefit.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.type.ApprovalStatusType;
import com.finefit.domain.model.type.RoleType;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class RegisterDTO {

  @JsonProperty
  private String trainerId;

  @JsonProperty
  private String password;

  @JsonProperty
  private String trainerName;

  @JsonProperty
  private String connect;

  @JsonProperty
  private String storeNumber;

  @JsonProperty
  private RoleType role;

  @JsonProperty
  private String team;

  @JsonCreator
  public RegisterDTO(String trainerId, String password, String trainerName,
      String connect, String storeNumber, RoleType role, String team)
  {
    this.trainerId = trainerId;
    this.password = password;
    this.trainerName = trainerName;
    this.connect = connect;
    this.storeNumber = storeNumber;
    this.role = role;
    this.team = team;
  }

  public static UserEntity toTrainerEntity(RegisterDTO registerDTO, String enPassword) {
    return UserEntity.builder()
        .trainerId(registerDTO.getTrainerId())
        .password(enPassword)
        .trainerName(registerDTO.getTrainerName())
        .connect(registerDTO.getConnect())
        .storeNumber(registerDTO.getStoreNumber())
        .role(registerDTO.getRole())
        .team(registerDTO.getTeam())
        .approvalStatus(ApprovalStatusType.PENDING)
        .createAt(LocalDate.now())
        .build();
  }
}
