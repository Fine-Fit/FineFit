package com.finefit.domain.model.dto;

import com.finefit.domain.entity.CounselEntity;
import com.finefit.domain.model.type.DrinkingFrequencyType;
import com.finefit.domain.model.type.ExerciseFrequencyType;
import com.finefit.domain.model.type.ExerciseGoalType;
import com.finefit.domain.model.type.ExerciseStyleType;
import com.finefit.domain.model.type.ExerciseType;
import com.finefit.domain.model.type.GenderType;
import java.time.LocalDate;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CounselDetailDTO {

  // ===== 기본 정보 =====

  /** 이름 */
  private String name;

  /** 연락처 (휴대폰 / 카카오톡 ID) */
  private String contact;

  /** 생년월일 / 나이 */
  private String birthDateOrAge;

  /** 성별
   *
   *   MALE("남성")
   *   FEMALE("여성")
   *   OTHER("기타")
   *
   * 전달을 할때 대문자 형식으로
   * */
  private GenderType gender;

  /** 키 / 현재 체중 */
  private String heightAndWeight;

  /** 희망 체중 / 희망 체형 or 운동 목표 */
  private String targetWeightOrBody;

  // ===== 1. 운동 목표 =====

  /** 운동 목적 (복수 선택 가능)
   *
   *   WEIGHT_LOSS("체중 감량 / 다이어트")
   *   WEIGHT_GAIN("체중 증가 / 벌크업")
   *   POSTURE_CORRECTION("체형 교정")
   *   STRENGTH_INCREASE("근력 향상")
   *   HEALTH_MANAGEMENT("건강 관리 / 체력 증가")
   *   PAIN_RELIEF("통증 개선")
   *   POSTURE_ADJUSTMENT("자세 교정")
   *   ETC("기타")
   *
   *   예시)
   *   WEIGHT_LOSS : false
   *   WEIGHT_GAIN : true
   *   POSTURE_CORRECTION: false
   *   STRENGTH_INCREASE : true
   *   HEALTH_MANAGEMENT : false
   *   PAIN_RELIEF : false
   *   POSTURE_ADJUSTMENT : false
   *   ETC : false
   *
   * */
  private Map<ExerciseGoalType, Boolean> exerciseGoal;

  /** 운동 목적 - 기타 내용 */
  private String exerciseGoalEtc;

  /** 목표 달성을 원하는 기간 */
  private String targetPeriod;

  // ===== 2. 운동 경험 =====

  /** 이전 퍼스널 트레이닝 경험 여부 */
  private boolean hasPtExperience;

  /** 평소 운동 빈도
   *
   *   NEVER("전혀 하지 않음")
   *   SOMETIMES("가끔 (주 1~2회)")
   *   REGULARLY("규칙적으로 (주 3회 이상)")
   *
   * */
  private ExerciseFrequencyType exerciseFrequency;

  /** 해본 운동 종류 (복수 선택 가능)
   *
   *   GYM("헬스장 운동")
   *   CARDIO("유산소 운동")
   *   HOME_TRAINING("홈트레이닝")
   *   PILATES_YOGA("필라테스 / 요가")
   *   MARTIAL_ARTS_CROSSFIT("격투기 / 크로스핏 등")
   *   ETC("기타")
   *
   *   예시)
   *   GYM("헬스장 운동") : true
   *   CARDIO : true
   *   HOME_TRAINING : false
   *   PILATES_YOGA : false
   *   MARTIAL_ARTS_CROSSFIT : true
   *   ETC : false
   * */
  private Map<ExerciseType, Boolean> exercise;

  /** 해본 운동 종류 - 기타 내용 */
  private String exerciseEtc;

  /** 운동 시 선호하는 스타일 (복수 선택 가능)
   *
   *   DETAILED_POSTURE("꼼꼼한 자세 교정")
   *   HIGH_INTENSITY("땀나는 고강도 운동")
   *   FUN_AND_LIGHT("재밌고 가벼운 운동")
   *   CUSTOMIZED("목적에 따라 맞춤 조절")
   *
   *
   *   예시)
   *   DETAILED_POSTURE : true
   *   HIGH_INTENSITY : false
   *   FUN_AND_LIGHT : false
   *   CUSTOMIZED : true
   *
   * */
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

  /** 복용 중인 약이나 주의해야 할 사항 */
  private String medicationOrPrecautions;

  // ===== 5. 생활 습관 =====

  /** 직업 / 평소 활동량 */
  private String occupationAndActivity;

  /** 하루 평균 수면 시간과 수면 질 */
  private String sleepInfo;

  /** 흡연 여부 */
  private boolean smoking;

  /** 음주 빈도
   *
   *   RARELY("거의 안 함")
   *   SOMETIMES("가끔 (주 1회 이하)")
   *   OFTEN("자주 (주 2회 이상)")
   *
   * */
  private DrinkingFrequencyType drinkingFrequency;

  /** 하루 평균 스트레스 수준 (1~5점) */
  private int stressLevel;

  /** 운동을 방해할 수 있는 요인 */
  private String exerciseObstacles;


  public static CounselEntity toCounselEntity(CounselDetailDTO counselDTO) {

    return CounselEntity.builder()
        .name(counselDTO.getName())
        .birthDateOrAge(counselDTO.getBirthDateOrAge())
        .gender(counselDTO.getGender())
        .heightAndWeight(counselDTO.getHeightAndWeight())
        .targetWeightOrBody(counselDTO.getTargetWeightOrBody())
        .exerciseGoal(counselDTO.exerciseGoal)
        .exerciseGoalEtc(counselDTO.getExerciseGoalEtc())
        .targetPeriod(counselDTO.getTargetPeriod())
        .hasPtExperience(counselDTO.isHasPtExperience())
        .exerciseFrequency(counselDTO.getExerciseFrequency())
        .exercise(counselDTO.exercise)
        .exerciseEtc(counselDTO.getExerciseEtc())
        .preferredStyle(counselDTO.getPreferredStyle())
        .mealsPerDay(counselDTO.getMealsPerDay())
        .mealTimeRegularity(counselDTO.getMealTimeRegularity())
        .favoriteFoods(counselDTO.getFavoriteFoods())
        .dietExperience(counselDTO.getDietExperience())
        .dietGoal(counselDTO.getDietGoal())
        .medicalHistory(counselDTO.getMedicalHistory())
        .medicationOrPrecautions(counselDTO.getMedicationOrPrecautions())
        .occupationAndActivity(counselDTO.occupationAndActivity)
        .sleepInfo(counselDTO.getSleepInfo())
        .smoking(counselDTO.isSmoking())
        .drinkingFrequency(counselDTO.getDrinkingFrequency())
        .stressLevel(counselDTO.getStressLevel())
        .exerciseObstacles(counselDTO.getExerciseObstacles())
        .createAt(LocalDate.now())
        .build();
  }

  public static CounselDetailDTO toCounselDTO(CounselEntity counsel) {

    return CounselDetailDTO.builder()
        .name(counsel.getName())
        .contact(counsel.getContact())
        .birthDateOrAge(counsel.getBirthDateOrAge())
        .gender(counsel.getGender())
        .heightAndWeight(counsel.getHeightAndWeight())
        .targetWeightOrBody(counsel.getTargetWeightOrBody())
        .exerciseGoal(counsel.getExerciseGoal())
        .exerciseGoalEtc(counsel.getExerciseGoalEtc())
        .targetPeriod(counsel.getTargetPeriod())
        .hasPtExperience(counsel.isHasPtExperience())
        .exerciseFrequency(counsel.getExerciseFrequency())
        .exercise(counsel.getExercise())
        .exerciseEtc(counsel.getExerciseEtc())
        .preferredStyle(counsel.getPreferredStyle())
        .mealsPerDay(counsel.getMealsPerDay())
        .mealTimeRegularity(counsel.getMealTimeRegularity())
        .favoriteFoods(counsel.getFavoriteFoods())
        .dietExperience(counsel.getDietExperience())
        .dietGoal(counsel.getDietGoal())
        .medicalHistory(counsel.getMedicalHistory())
        .medicationOrPrecautions(counsel.getMedicationOrPrecautions())
        .occupationAndActivity(counsel.getOccupationAndActivity())
        .sleepInfo(counsel.getSleepInfo())
        .smoking(counsel.isSmoking())
        .drinkingFrequency(counsel.getDrinkingFrequency())
        .stressLevel(counsel.getStressLevel())
        .exerciseObstacles(counsel.getExerciseObstacles())
        .build();

  }
}
