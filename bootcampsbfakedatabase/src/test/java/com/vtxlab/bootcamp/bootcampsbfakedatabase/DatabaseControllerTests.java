package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import static org.mockito.ArgumentMatchers.contains;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@WebMvcTest(DatabaseController.class) // Inject the web layer related bean to context only.
// In this test env, component scan will ignore @Service, @Configuration, etc.
// but includes controller beans, mockmvc beans, etc.
class DatabaseControllerTests {

  @Autowired
  private MockMvc mockMvc; // similar to postman

  // @Autowired // You cannot autowired service bean in WebMvcTest env.
  @MockBean // similar to @Mock
  // Because Controller Bean need to autowired catDatabaseService
  private CatDatabaseService catDatabaseService;

  @Test
  void testGetCat() throws Exception {
    // assumption
    Cat mockedReturnCat = new Cat("ABCD", 3);
    // when
    Mockito.when(catDatabaseService.getCat(1)).thenReturn(mockedReturnCat);
    // assert
    mockMvc.perform(get("/api/v1/cat/{idx}", "1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("ABCD"))
        .andExpect(jsonPath("$.age").value(3))
        .andDo(print()); // similar to sysout, toString()

    mockMvc.perform(get("/api/v1/cat2/{idx}", "1"))
        .andExpect(status().isNotFound())
        .andDo(print());
}

@Test
void testPostCat() throws Exception{
  Cat catToPost = new Cat("John",2);
  String contentString = new ObjectMapper().writeValueAsString(catToPost);
  Mockito.when(catDatabaseService.setCat(1, catToPost)).thenReturn(catToPost);

  mockMvc.perform(post("/api/v1/cat/{idx}","1")//
  .contentType(MediaType.APPLICATION_JSON)//
  .content(contentString))//
  .andExpect(status().isOk())//
  .andExpect(jsonPath("$.name").value("John"))//
  .andExpect(jsonPath("$.age").value(2))//
  .andDo(print());
}

@Test
void testPutCat() throws Exception {
  Cat catToPut = new Cat("Peter", 3);
  String contentString = new ObjectMapper().writeValueAsString(catToPut);
  // when
  Mockito.when(catDatabaseService.updateCat(0, catToPut))
      .thenReturn(catToPut);
  // assert
  mockMvc.perform(put("/api/v1/cat/{idx}", "0") //
      .contentType(MediaType.APPLICATION_JSON) //
      .content(contentString)) //
      .andExpect(status().isOk()) // http code 200 - OK
      .andExpect(jsonPath("$.name").value("Peter")) //
      .andExpect(jsonPath("$.age").value(3)) //
      .andDo(print()); // similar to sysout, toString()
}








}
