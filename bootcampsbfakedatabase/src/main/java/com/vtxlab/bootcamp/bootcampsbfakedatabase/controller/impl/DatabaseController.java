package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

// @Controller
// @ResponseBody // JSON
@RestController
// Create an object of this class, and put it into spring context
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

  @Autowired // (required = false) // dependency injection 自動裝配
  // Polymorphism
  private CatDatabaseService catDatabaseService;

  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
    return catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    // new CatDatabaseServiceImpl().setCatToStaticMemory(index,
    // new Cat(name, age));
    catDatabaseService.setCatToStaticMemory(index, new Cat(name, age));
  }

  @Override
  public Cat createCat(int idx, Cat cat) {
    return catDatabaseService.setCatToStaticMemory(idx, cat);
  }

  @Override
  public Boolean deleteCat(int idx) {
    return catDatabaseService.deleteCatToStaticMemory(idx);
  }

  @Override
  public Cat updataCat(int idx, Cat cat) {
    return catDatabaseService.updataCatToStaticMemory(idx, cat);
  }
}
