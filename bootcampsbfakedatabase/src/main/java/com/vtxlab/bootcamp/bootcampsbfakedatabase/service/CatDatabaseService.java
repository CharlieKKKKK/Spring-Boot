package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {

  Cat getCatFromStaticMemory(int index);

  Cat setCatToStaticMemory(int index, Cat cat);

  Boolean deleteCatToStaticMemory(int index);

  Cat updataCatToStaticMemory(int index, Cat cat);

}
