package com.vtxlab.bootcamp.springboot_exercise_1.infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

  private String code;

  private String message;

  private T data;

}
