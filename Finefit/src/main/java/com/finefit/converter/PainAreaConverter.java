package com.finefit.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finefit.domain.model.type.PainAreaType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.HashMap;
import java.util.Map;


@Converter
public class PainAreaConverter implements AttributeConverter<Map<PainAreaType, Boolean>, String> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Map<PainAreaType, Boolean> attribute) {
    try {
      return objectMapper.writeValueAsString(attribute);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Map<PainAreaType, Boolean> convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData,
          new TypeReference<>() {});
    } catch (JsonProcessingException e) {
      return new HashMap<>();
    }
  }
}