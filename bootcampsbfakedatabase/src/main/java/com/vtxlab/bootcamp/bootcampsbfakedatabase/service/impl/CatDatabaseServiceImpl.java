package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
// @Component
// Create an object of this class, put it into spring context
public class CatDatabaseServiceImpl implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  @Override
  public Cat getCatFromStaticMemory(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public Cat setCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.setCat(index, cat);
  }

  @Override
  public Boolean deleteCatToStaticMemory(int index) {
    return CatDatabase.deleteCat(index);
}

  @Override
  public Cat updataCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.updataCat(index, cat);
}

}
