package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Post {

  private int userId;

  private int id;

  private String title;

  private String body;
  
}
