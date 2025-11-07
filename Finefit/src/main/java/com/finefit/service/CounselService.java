package com.finefit.service;

import com.finefit.domain.model.dto.CounselDetailDTO;
import com.finefit.domain.model.dto.ResultResponse;

public interface CounselService {

  ResultResponse writeCounsel(CounselDetailDTO counselDTO);
}
