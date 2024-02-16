package com.vtxlab.bootcamp.springboot_exercise_1.infra;

public class DivideByZeroException extends ArithmeticException {

  public DivideByZeroException() {
    super(Syscode.DIVID_BY_ZERO.getMessage());
  }

}
