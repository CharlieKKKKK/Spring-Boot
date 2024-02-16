package com.vtxlab.bootcamp.springboot_exercise_1.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."), //
  NOTFOUND("100000", "Not Found."), //
  JPH_NOT_AVAILABLE("100001", "JsonPlaceHolder API is unavailable."), //
  // Runtime Exception
  REST_CLIENT_EXCEPTION("900001", "RestClient Exception."), //
  NPE_EXCEPTION("900000", "Runtime Exception - NPE."), //
  GENERAL_EXCEPTION("999999", "General Exception."),//

  DIVID_BY_ZERO("2","Divided by zero."),//
  NUM_FORMAT_EXCEPTION("3","Input Exception"),//
  INVALID_INPUT("4","Invalid Input Exception"),//
  INVALID_OPERA("5","Invalid operation Exception")
  ;

  private String code;

  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
