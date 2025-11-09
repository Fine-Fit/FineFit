package com.finefit.domain.entity;

import com.finefit.converter.ExerciseConverter;
import com.finefit.converter.ExerciseGoalConverter;
import com.finefit.converter.PainAreaConverter;
import com.finefit.domain.model.type.DrinkingFrequencyType;
import com.finefit.domain.model.type.ExerciseFrequencyType;
import com.finefit.domain.model.type.ExerciseGoalType;
import com.finefit.domain.model.type.ExerciseStyleType;
import com.finefit.domain.model.type.ExerciseType;
import com.finefit.domain.model.type.GenderType;
import com.finefit.domain.model.type.PainAreaType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Counsel")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CounselEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long counselId;

  // ===== 기본 정보 =====

  /** 이름 */
  private String name;

  /** 연락처 (휴대폰 / 카카오톡 ID) */
  private String contact;

  /** 생년월일 / 나이 */
  private String birthDateOrAge;

  /** 성별 */
  @Enumerated(EnumType.STRING)
  private GenderType gender;

  /** 키 / 현재 체중 */
  private String heightAndWeight;

  /** 희망 체중 / 희망 체형 or 운동 목표 */
  private String targetWeightOrBody;

  // ===== 1. 운동 목표 =====

  /** 운동 목적 (복수 선택 가능) */
  @Column(columnDefinition = "JSON")
  @Convert(converter = ExerciseGoalConverter.class)
  private Map<ExerciseGoalType, Boolean> exerciseGoal;

  /** 운동 목적 - 기타 내용 */
  private String exerciseGoalEtc;

  /** 목표 달성을 원하는 기간 */
  private String targetPeriod;

  // ===== 2. 운동 경험 =====

  /** 이전 퍼스널 트레이닝 경험 여부 */
  private boolean hasPtExperience;

  /** 평소 운동 빈도 */
  @Enumerated(EnumType.STRING)
  private ExerciseFrequencyType exerciseFrequency;

  /** 해본 운동 종류 (복수 선택 가능) */
  @Column(columnDefinition = "JSON")
  @Convert(converter = ExerciseConverter.class)
  private Map<ExerciseType, Boolean> exercise;

  /** 해본 운동 종류 - 기타 내용 */
  private String exerciseEtc;

  /** 운동 시 선호하는 스타일 */
  @Enumerated(EnumType.STRING)
  private ExerciseStyleType preferredStyle;

  // ===== 3. 식습관 =====

  /** 하루 평균 식사 횟수 */
  private String mealsPerDay;

  /** 식사 시간 규칙성 여부 */
  private String mealTimeRegularity;

  /** 평소 즐겨 먹는 음식 / 자주 먹는 간식 */
  private String favoriteFoods;

  /** 식단 조절 또는 다이어트 경험 */
  private String dietExperience;

  /** 현재 식단에 대한 고민이나 목표 */
  private String dietGoal;

  // ===== 4. 건강 상태 =====

  /** 현재 또는 과거 질환이나 통증 */
  private String medicalHistory;

  /** 통증이 있는 부위 (복수 선택 가능) */
  @Column(columnDefinition = "JSON")
  @Convert(converter = PainAreaConverter.class)
  private Map<PainAreaType, Boolean> painArea;

  /** 통증 부위 - 기타 내용 */
  private String painAreaEtc;

  /** 복용 중인 약이나 주의해야 할 사항 */
  private String medicationOrPrecautions;

  // ===== 5. 생활 습관 =====

  /** 직업 / 평소 활동량 */
  private String occupationAndActivity;

  /** 하루 평균 수면 시간과 수면 질 */
  private String sleepInfo;

  /** 흡연 여부 */
  private boolean smoking;

  /** 음주 빈도 */
  @Enumerated(EnumType.STRING)
  private DrinkingFrequencyType drinkingFrequency;

  /** 하루 평균 스트레스 수준 (1~5점) */
  private int stressLevel;

  /** 운동을 방해할 수 있는 요인 */
  private String exerciseObstacles;

  private LocalDate createAt;
}
