package com.finefit.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finefit.domain.model.type.ExerciseGoalType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

@Converter
public class ExerciseGoalConverter implements
    AttributeConverter<Map<ExerciseGoalType, Boolean>, String> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Map<ExerciseGoalType, Boolean> attribute) {
    try {
      return objectMapper.writeValueAsString(attribute);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Map<ExerciseGoalType, Boolean> convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData,
          new TypeReference<>() {});
    } catch (JsonProcessingException e) {
      return new HashMap<>();
    }
  }
}
