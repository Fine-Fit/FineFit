package com.finefit.controller;

import com.finefit.domain.model.dto.CounselDetailDTO;
import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.service.CounselService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/counsel")
@RequiredArgsConstructor
public class CounselController {

  private final CounselService counselService;

  @PostMapping("/write")
  public ResponseEntity<ResultResponse> writeCounsel(@RequestBody CounselDetailDTO counselDTO) {

    ResultResponse response = counselService.writeCounsel(counselDTO);
    return new ResponseEntity<>(response, response.getStatus());

  }
}
