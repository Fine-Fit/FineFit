package com.finefit.domain.entity;

import com.finefit.domain.model.type.ApprovalStatusType;
import com.finefit.domain.model.type.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(nullable = false)
  private String trainerId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String trainerName;

  @Column(nullable = false)
  private String connect;

  @Column(nullable = false)
  private String storeNumber;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private RoleType role;

  @Column(nullable = false)
  private String team;

  @Enumerated(EnumType.STRING)
  private ApprovalStatusType approvalStatus;

  @Column(nullable = false)
  private LocalDate createAt;

}