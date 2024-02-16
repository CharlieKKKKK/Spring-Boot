package com.vtxlab.bootcamp.springboot_exercise_1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.springboot_exercise_1.controller.ExerciseOperation;
import com.vtxlab.bootcamp.springboot_exercise_1.model.ResultDTO;
import com.vtxlab.bootcamp.springboot_exercise_1.service.ExerciseService;

@RestController
@RequestMapping(value = "/api/v1")
public class ExerciseController implements ExerciseOperation {

  @Autowired
  private ExerciseService exerciseService;

  @Override
  public ResultDTO calculatorE(String x, String y, String operation) {
    String result = exerciseService.calculatorE(x, y, operation);
    ResultDTO resultDTO = ResultDTO.builder().x(x).y(y).operation(operation).result(result).build();
    return resultDTO;
  }

  @Override
  public ResultDTO calculatorE1(String x, String y, String operation) {
    return this.calculatorE(x, y, operation);
  }

  @Override
  public ResultDTO calculatorE2(ResultDTO requestDTO) {
    return this.calculatorE(requestDTO.getX(), requestDTO.getY(), requestDTO.getOperation());
  }

}
