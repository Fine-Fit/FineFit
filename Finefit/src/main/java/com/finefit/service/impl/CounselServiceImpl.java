package com.finefit.service.impl;

import com.finefit.domain.entity.CounselEntity;
import com.finefit.domain.model.dto.CounselDetailDTO;
import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.type.SuccessResultType;
import com.finefit.domain.repository.CounselRepository;
import com.finefit.service.CounselService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService {

  private final CounselRepository counselRepository;

  @Override
  public ResultResponse writeCounsel(CounselDetailDTO counselDTO) {
    CounselEntity counsel = CounselDetailDTO.toCounselEntity(counselDTO);

    counselRepository.save(counsel);

    return ResultResponse.of(SuccessResultType.SUCCESS_REQUEST_COUNSEL);
  }
}
