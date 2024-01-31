package com.vtxlab.bootcamp.helloworld.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.bootcamp.helloworld.model.Cat;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  @GetMapping(value = "/helloworld")
  public String helloworld() {
    return "Hello Charlie";
  }

  @GetMapping(value = "/charlie")
  public int ABC() {
    return 2046;
  }

  @GetMapping(value = "/charlie1")
  public Character charABC() {
    return 'W';
  }

  @GetMapping(value = "/charlie2")
  public Double doubleABC() {
    return Double.valueOf(159.7d);
  }

  @GetMapping(value = "/Cat1")
  public Cat Cat() {
    return new Cat("Jack", 15);
  }

  @GetMapping(value = "/Cat2")
  public Cat Cat2() {
    return Cat.builder().age(28).name("May").build();
  }

  @GetMapping(value = "/Cat3")
  public List<Cat> Cat3() {
    return new ArrayList<Cat>(List.of(new Cat("Jay", 14), new Cat("John", 23), new Cat("Amy", 55)));
  }

  @GetMapping(value = "/Cat4")
  public Cat[] Cat4() {
    return new Cat[] { new Cat("Jay", 99), new Cat("John", 999999), new Cat("Amy", 999999999) };
  }

  @GetMapping(value = "/Cat5")
  public List<Cat> getCats() {
    return Stream.of(new Cat("Jay", 14), new Cat("John", 23), new Cat("Amy", 55))
        .collect(Collectors.toList());
  }

}
