package com.finefit.controller;


import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.type.ApprovalStatusType;
import com.finefit.domain.model.type.CounselStatusType;
import com.finefit.service.OperatorService;
import jakarta.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/operator")
public class OperatorController {

  private final OperatorService operatorService;

  @GetMapping("/approval")
  public ResponseEntity<ResultResponse> getApprovalUsers(HttpServletRequest request,
      @RequestParam(required = false) ApprovalStatusType approvalStatus)
  {

    ResultResponse response = operatorService.getApprovalUsersByStatus(request, approvalStatus);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @PutMapping("/approval")
  public ResponseEntity<ResultResponse> updateApprovalStatus(HttpServletRequest request,
      @RequestParam Long userId, @RequestParam ApprovalStatusType approvalStatus)
  {
    ResultResponse response = operatorService.updateApprovalStatus(request, userId, approvalStatus);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @GetMapping("/counsel")
  public ResponseEntity<ResultResponse> getCounsel(HttpServletRequest request,
      @RequestParam(required = false) CounselStatusType counselStatus)
  {

    ResultResponse response = operatorService.getCounsel(request, counselStatus);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @PutMapping("/counsel")
  public ResponseEntity<ResultResponse> updateCounselStatus(HttpServletRequest request,
      @RequestParam Long counselId, @RequestParam CounselStatusType counselStatus) {

    ResultResponse response = operatorService.updateCounselStatus(request, counselId, counselStatus);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @GetMapping("/counsel/{counselId}")
  public ResponseEntity<ResultResponse> getCounselById(HttpServletRequest request,
      @PathVariable("counselId") Long counselId)
  {

    ResultResponse response = operatorService.getCounselById(request, counselId);
    return new ResponseEntity<>(response, response.getStatus());
  }
}
