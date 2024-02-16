package com.vtxlab.bootcamp.springboot_exercise_1.infra;

import lombok.Getter;

@Getter
public enum Method {
  ADD,
  SUB,
  MUL,
  DIV,;

  public static Method operatorEnum(String operation) {
    return switch (operation.toUpperCase()) {
      case "ADD" -> Method.ADD;
      case "SUB" -> Method.SUB;
      case "MUL" -> Method.MUL;
      case "DIV" -> Method.DIV;
      default -> throw new InvalidOperaException();
    };

  }
}