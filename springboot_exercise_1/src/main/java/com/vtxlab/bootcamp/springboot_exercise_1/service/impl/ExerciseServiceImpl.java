package com.vtxlab.bootcamp.springboot_exercise_1.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.springboot_exercise_1.infra.DivideByZeroException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.InvalidInputException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.Method;
import com.vtxlab.bootcamp.springboot_exercise_1.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

  @Override
  public String calculatorE(String x, String y, String operation) {

    BigDecimal tempX = BigDecimal.valueOf(0.0d);
    BigDecimal tempY = BigDecimal.valueOf(0.0d);

    try {
      tempX = BigDecimal.valueOf(Double.parseDouble(x));
      tempY = BigDecimal.valueOf(Double.parseDouble(y));
    } catch (IllegalArgumentException e) {
      throw new InvalidInputException();
    }
    // BigDecimal tempX = BigDecimal.valueOf(Double.valueOf(x));
    // BigDecimal tempY = BigDecimal.valueOf(Double.valueOf(y));
    String result = "";

    switch (Method.operatorEnum(operation)) {
      case ADD -> {
        result = tempX.add(tempY).setScale(5, RoundingMode.HALF_UP).toString();
        break;
      }
      case SUB -> {
        result = tempX.subtract(tempY).setScale(5, RoundingMode.HALF_UP).toString();
        break;
      }
      case MUL -> {
        result = tempX.multiply(tempY).setScale(5, RoundingMode.HALF_UP).toString();
        break;
      }
      case DIV -> {
        if (tempY.compareTo(BigDecimal.ZERO) == 0 ||
            tempX.compareTo(BigDecimal.ZERO) == 0) {
          throw new DivideByZeroException();
        }
        result = tempX.divide(tempY).setScale(5, RoundingMode.HALF_UP).toString();
        break;
      }
    }
    return result;
  }
}
