package com.vtxlab.bootcamp.springboot_exercise_1.infra;

public class InvalidOperaException extends IllegalArgumentException {
  public InvalidOperaException() {
    super(Syscode.INVALID_OPERA.getMessage());
  }
}
