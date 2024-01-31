package com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bootcampsbcalculator.controller.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")
public class Controller implements Operation {

  @Autowired
  private CalculatorService catDatabaseService;

  @Override
  public double calculator(double x, double y, String math) {
    return catDatabaseService.calculator(x, y, math);
  }
}
