package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@WebMvcTest(DatabaseController.class)
public class DatabaseControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CatDatabaseService catDatabaseService;

  @Test
  void testGetCat() {
    Cat mockedReturnCat = new Cat("ABCD", 3);
    Mockito.when(catDatabaseService.getCat(1)).thenReturn(mockedReturnCat);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat/{idx}", "1"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ABCD"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(3))
        .andDo(MockMvcResultHandlers.print());
  }

}
