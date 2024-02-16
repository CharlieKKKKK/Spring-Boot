package com.vtxlab.bootcamp.springboot_exercise_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
public class InputDTO {
  private String x;
  private String y;
  private String operation;
}
