package com.vtxlab.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vtxlab.bootcamp.dto.CatDTO;
import com.vtxlab.bootcamp.model.Cat;

public class CatController {

  public CatDTO getCat() {
    Cat cat = new CatService().getCat();
    String description = "Cat Name=" + cat.getName() + "Cat Age=" + cat.getAge();
    String logo = "Apple";
    CatDTO catDTO = new CatDTO(description, logo);
    return catDTO;
  }

  public Map<String, Integer> getCats() { // String -> name, Integer -> age
    // call getCats();
    // CatService catService = new CatService();
    List<Cat> cats = new CatService().getCats();
    Map<String, Integer> catMap = new HashMap<>();
    for (Cat C : cats) {
      catMap.put(C.getName(), C.getAge());
    }
    return catMap;
  }

  public List<Cat> getCaList(){
    return new CatService().getCats();
  }
}
