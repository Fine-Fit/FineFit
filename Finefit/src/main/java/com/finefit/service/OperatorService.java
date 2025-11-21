package com.finefit.service;



import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.type.ApprovalStatusType;
import com.finefit.domain.model.type.CounselStatusType;
import jakarta.servlet.http.HttpServletRequest;

public interface OperatorService {

  ResultResponse getApprovalUsersByStatus(HttpServletRequest request, ApprovalStatusType approvalStatus);

  ResultResponse updateApprovalStatus(HttpServletRequest request, Long userId, ApprovalStatusType approvalStatus);

  ResultResponse getCounsel(HttpServletRequest request, CounselStatusType counselStatus);

  ResultResponse updateCounselStatus(HttpServletRequest request, Long counselId, CounselStatusType counselStatus);

  ResultResponse getCounselById(HttpServletRequest request, Long counselId);
}
