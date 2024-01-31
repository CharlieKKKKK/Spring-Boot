package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public interface Operation {

  @GetMapping(value = "/x/{x}/y/{y}/operation/{math}")
  double calculator(@PathVariable double x, //
      @PathVariable double y, //
      @PathVariable String math);
}
