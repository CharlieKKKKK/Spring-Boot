package com.vtxlab.bootcamp.springboot_exercise_1.controller;

//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bootcamp.springboot_exercise_1.model.ResultDTO;

@Component
public interface ExerciseOperation {

  @GetMapping(value = "/{x}/{y}/{operation}")
  // @ResponseStatus(value = HttpStatus.OK)
  ResultDTO calculatorE(@PathVariable String x, //
      @PathVariable String y, //
      @PathVariable String operation);

  @GetMapping(value = "/")
  // @ResponseStatus(value = HttpStatus.OK)
  ResultDTO calculatorE1(@RequestParam String x, //
      @RequestParam String y, //
      @RequestParam String operation);

  @PostMapping(value = "/")
  // @ResponseStatus(value = HttpStatus.OK)
  ResultDTO calculatorE2(@RequestBody ResultDTO requestDTO);
}
