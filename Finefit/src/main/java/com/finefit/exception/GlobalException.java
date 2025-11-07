package com.finefit.exception;

import com.finefit.domain.model.dto.ResultResponse;
import com.finefit.domain.model.type.FailedResultType;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

  private final ResultResponse resultResponse;

  public GlobalException(FailedResultType failedResultCode) {
    super("");
    this.resultResponse = ResultResponse.of(failedResultCode);
  }

  public GlobalException(ResultResponse resultResponse) {
    super("");
    this.resultResponse = resultResponse;
  }

}
