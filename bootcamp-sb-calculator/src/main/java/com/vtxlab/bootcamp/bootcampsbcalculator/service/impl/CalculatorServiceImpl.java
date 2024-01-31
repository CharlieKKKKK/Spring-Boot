package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public double calculator(double x, double y, String math) {
    double ans = 0.0d;
    if ("a".equals(math)) {
      ans = BigDecimal.valueOf(x).add(BigDecimal.valueOf(y)).doubleValue();
    }
    if ("s".equals(math)) {
      ans = BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y)).doubleValue();
    }
    if ("m".equals(math)) {
      ans = BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
    }
    if ("d".equals(math)) {
      ans = BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y)).doubleValue();
    }
    return ans;
  }

}
