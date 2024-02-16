package com.vtxlab.bootcamp.springboot_exercise_1.infra;

public class InvalidInputException extends IllegalArgumentException{
  
  public InvalidInputException(){
    super(Syscode.INVALID_INPUT.getMessage());
}
}
