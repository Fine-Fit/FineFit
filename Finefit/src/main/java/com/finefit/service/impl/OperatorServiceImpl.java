package com.finefit.service.impl;

import com.finefit.auth.JwtUtil;
import com.finefit.domain.entity.CounselEntity;
import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.dto.ApprovalUserDTO;
import com.finefit.domain.model.dto.CounselDTO;
import com.finefit.domain.model.dto.CounselDetailDTO;
import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.type.ApprovalStatusType;
import com.finefit.domain.model.type.FailedResultType;
import com.finefit.domain.model.type.RoleType;
import com.finefit.domain.model.type.SuccessResultType;
import com.finefit.domain.repository.CounselRepository;
import com.finefit.domain.repository.UserRepository;
import com.finefit.exception.GlobalException;
import com.finefit.service.OperatorService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperatorServiceImpl implements OperatorService {

  private final JwtUtil jwtUtil;
  private final UserRepository userRepository;
  private final CounselRepository counselRepository;

  public UserEntity getUserByAccessToken(HttpServletRequest request) {
    return userRepository.findById(jwtUtil.getUserId(request))
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));
  }

  public void isAboveOrEqual(UserEntity user, RoleType roleType){
    if (!RoleType.isAboveOrEqual(user.getRole(), roleType)) {
      throw new GlobalException(FailedResultType.FAILED_ACCESS_DENIED);
    }
  }

  @Override
  public ResultResponse getApprovalUsersByStatus(HttpServletRequest request,
      ApprovalStatusType approvalStatus) {

    UserEntity user = getUserByAccessToken(request);
    isAboveOrEqual(user, RoleType.MANAGER);

    List<UserEntity> approvalUsers;
    if (approvalStatus == null) {
      approvalUsers = userRepository.findByUserIdNot(user.getUserId());
    } else {
      approvalUsers = userRepository.findByUserIdNotAndApprovalStatus(user.getUserId(), approvalStatus);
    }

    List<ApprovalUserDTO> approvalUserList = ApprovalUserDTO.toApproveUser(approvalUsers);

    return new ResultResponse(SuccessResultType.SUCCESS_GET_APPROVAL_USERS, approvalUserList);
  }

  @Override
  public ResultResponse updateApprovalStatus(HttpServletRequest request, Long userId,
      ApprovalStatusType approvalStatus) {

    UserEntity user = getUserByAccessToken(request);
    isAboveOrEqual(user, RoleType.MANAGER);

    UserEntity approveUser = userRepository.findByUserId(userId)
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));

    userRepository.save(UserEntity.builder()
        .userId(approveUser.getUserId())
        .trainerId(approveUser.getTrainerId())
        .password(approveUser.getPassword())
        .trainerName(approveUser.getTrainerName())
        .connect(approveUser.getConnect())
        .storeNumber(approveUser.getStoreNumber())
        .role(approveUser.getRole())
        .team(approveUser.getTeam())
        .approvalStatus(approvalStatus)
        .createAt(approveUser.getCreateAt())
        .build());

    return ResultResponse.of(SuccessResultType.SUCCESS_UPDATE_USER_APPROVAL);
  }

  @Override
  public ResultResponse getCounsel(HttpServletRequest request) {

    List<CounselEntity> counsel = counselRepository.findAll();
    List<CounselDTO> counselsList = CounselDTO.toCounselsDTO(counsel);

    return new ResultResponse(SuccessResultType.SUCCESS_GET_COUNSEL_LIST, counselsList);
  }

  @Override
  public ResultResponse getCounselById(HttpServletRequest request, Long counselId) {

    CounselEntity counselEntity = counselRepository.findByCounselId(counselId)
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_COUNSEL_NOT_FOUND));

    CounselDetailDTO counsel = CounselDetailDTO.toCounselDTO(counselEntity);

    return new ResultResponse(SuccessResultType.SUCCESS_GET_COUNSEL_DETAILS, counsel);
  }
}