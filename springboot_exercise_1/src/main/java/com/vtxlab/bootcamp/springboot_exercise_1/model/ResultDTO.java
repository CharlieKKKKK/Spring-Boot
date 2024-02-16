package com.vtxlab.bootcamp.springboot_exercise_1.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResultDTO {
  private String x;
  private String y;
  private String operation;
  private String result;

}
