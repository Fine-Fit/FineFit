package com.finefit.domain.model.dto;


import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.type.ApprovalStatusType;
import com.finefit.domain.model.type.RoleType;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApprovalUserDTO {

  private Long userId;

  private String trainerId;

  private String trainerName;

  private String connect;

  private String storeNumber;

  private RoleType role;

  private String team;

  private ApprovalStatusType approvalStatus;

  public static List<ApprovalUserDTO> toApproveUser(List<UserEntity> users) {
    List<ApprovalUserDTO> approveUsers = new ArrayList<>();

    for (UserEntity user : users) {
      ApprovalUserDTO approvalUserDTO = ApprovalUserDTO.builder()
          .userId(user.getUserId())
          .trainerId(user.getTrainerId())
          .trainerName(user.getTrainerName())
          .connect(user.getConnect())
          .storeNumber(user.getStoreNumber())
          .role(user.getRole())
          .team(user.getTeam())
          .approvalStatus(user.getApprovalStatus())
          .build();

      approveUsers.add(approvalUserDTO);
    }

    return approveUsers;
  }

}
