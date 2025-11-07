package com.finefit.domain.model.dto;

import com.finefit.domain.entity.CounselEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CounselDTO {

  private Long counselId;

  private String name;

  private String connect;

  private LocalDate createAt;

  public static List<CounselDTO> toCounselsDTO(List<CounselEntity> counsel) {
    List<CounselDTO> counselList = new ArrayList<>();

    for (CounselEntity counselEntity : counsel) {
      CounselDTO counselsDTO = CounselDTO.builder()
          .counselId(counselEntity.getCounselId())
          .name(counselEntity.getName())
          .connect(counselEntity.getContact())
          .createAt(counselEntity.getCreateAt())
          .build();

      counselList.add(counselsDTO);
    }

    return counselList;
  }
}
