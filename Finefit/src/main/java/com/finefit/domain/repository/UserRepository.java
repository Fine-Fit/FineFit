package com.finefit.domain.repository;

import com.finefit.domain.entity.UserEntity;
import com.finefit.domain.model.type.ApprovalStatusType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  boolean existsByTrainerId(String trainerId);

  Optional<UserEntity> findByTrainerId(String trainerId);

  List<UserEntity> findByUserIdNotAndApprovalStatus(Long userId, ApprovalStatusType approvalStatus);

  List<UserEntity> findByUserIdNot(Long userId);

  Optional<UserEntity> findByUserId(Long userId);
}
