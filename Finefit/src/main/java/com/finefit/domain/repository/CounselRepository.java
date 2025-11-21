package com.finefit.domain.repository;


import com.finefit.domain.entity.CounselEntity;
import com.finefit.domain.model.type.CounselStatusType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounselRepository extends JpaRepository<CounselEntity, Long> {

  Optional<CounselEntity> findByCounselId(Long counselId);

  List<CounselEntity> findAllByCounselStatus(CounselStatusType counselStatus);

}
