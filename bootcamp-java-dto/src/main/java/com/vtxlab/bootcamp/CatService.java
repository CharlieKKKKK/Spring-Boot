package com.vtxlab.bootcamp;

import java.util.ArrayList;
import java.util.List;

import com.vtxlab.bootcamp.model.Cat;

public class CatService {

  public Cat getCat() {
    return new Cat("John", 1);
  }

  public List<Cat> getCats() {
    List<Cat> cat = new ArrayList<>();
    Cat cat1 = new Cat("John", 2);
    Cat cat2 = new Cat("Mary", 3);
    cat.add(cat1);
    cat.add(cat2);
    return cat;
  }

  public List<Cat> getCatList() {
    if (index < 0)
      throw new IllegalArgumentException();
    List<Cat> cats = new ArrayList<>();
    try {
      cats = callJPH();
      if(index < cats.size())
        throw new IllegalArgumentException();
      if(cats != null)
    } catch (Exception e) {
      throw new Exception();
    }
    return cats;
  }

  public List<Cat> callJPH() {
    return List.of(new Cat("John", 2), new Cat("Mary", 3));
  }
}
