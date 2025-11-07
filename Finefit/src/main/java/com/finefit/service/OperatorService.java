package com.finefit.service;



import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.type.ApprovalStatusType;
import jakarta.servlet.http.HttpServletRequest;

public interface OperatorService {

  ResultResponse getApprovalUsersByStatus(HttpServletRequest request, ApprovalStatusType approvalStatus);

  ResultResponse updateApprovalStatus(HttpServletRequest request, Long userId, ApprovalStatusType approvalStatus);

  ResultResponse getCounsel(HttpServletRequest request);

  ResultResponse getCounselById(HttpServletRequest request, Long counselId);
}
