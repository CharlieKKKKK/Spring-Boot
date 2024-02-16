package com.vtxlab.bootcamp.springboot_exercise_1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.springboot_exercise_1.controller.impl.ExerciseController;
import com.vtxlab.bootcamp.springboot_exercise_1.model.InputDTO;
import com.vtxlab.bootcamp.springboot_exercise_1.service.ExerciseService;

@WebMvcTest(ExerciseController.class)
public class ExerciseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ExerciseService exerciseService;

  @Test
  void testAdd() throws Exception {

    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "add")).thenReturn("21.4");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "18.8", "2.6", "add")//
        .param("x", "18.8")//
        .param("y", "2.6")//
        .param("operation", "add"))//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("add")) //
        .andExpect(jsonPath("$.result").value("21.4")) //
        .andDo(print());
  }

  @Test
  void testSub() throws Exception {

    Mockito.when(exerciseService.calculatorE("18.8", "28.5", "sub")).thenReturn("-9.7");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "18.8", "28.5", "sub")//
        .param("x", "18.8")//
        .param("y", "28.5")//
        .param("operation", "sub"))//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("28.5")) //
        .andExpect(jsonPath("$.operation").value("sub")) //
        .andExpect(jsonPath("$.result").value("-9.7")) //
        .andDo(print());

  }

  @Test
  void testMul() throws Exception {

    Mockito.when(exerciseService.calculatorE("18.8", "2.0", "mul")).thenReturn("37.6");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "18.8", "2.0", "mul")//
        .param("x", "18.8")//
        .param("y", "2.0")//
        .param("operation", "mul"))//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.0")) //
        .andExpect(jsonPath("$.operation").value("mul")) //
        .andExpect(jsonPath("$.result").value("37.6")) //
        .andDo(print());

  }

  @Test
  void testDiv() throws Exception {

    Mockito.when(exerciseService.calculatorE("18.8", "2.0", "div")).thenReturn("9.4");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "18.8", "2.0", "div")//
        .param("x", "18.8")//
        .param("y", "2.0")//
        .param("operation", "div"))//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.0")) //
        .andExpect(jsonPath("$.operation").value("div")) //
        .andExpect(jsonPath("$.result").value("9.4")) //
        .andDo(print());

  }

  // ------------------------------------------------------------------
  @Test
  void testAdd2() throws Exception {
    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "add")).thenReturn("21.4");

    mockMvc.perform(get("/api/v1/")//
        .param("x", "18.8") //
        .param("y", "2.6") //
        .param("operation", "add")) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("add")) //
        .andExpect(jsonPath("$.result").value("21.4")) //
        .andDo(print());
  }

  @Test
  void testSub2() throws Exception {
    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "sub")).thenReturn("16.2");

    mockMvc.perform(get("/api/v1/")//
        .param("x", "18.8") //
        .param("y", "2.6") //
        .param("operation", "sub")) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("sub")) //
        .andExpect(jsonPath("$.result").value("16.2")) //
        .andDo(print());
  }

  @Test
  void testMul2() throws Exception {
    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "mul")).thenReturn("48.88");

    mockMvc.perform(get("/api/v1/")//
        .param("x", "18.8") //
        .param("y", "2.6") //
        .param("operation", "mul")) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("mul")) //
        .andExpect(jsonPath("$.result").value("48.88")) //
        .andDo(print());
  }

  @Test
  void testDiv2() throws Exception {
    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "div")).thenReturn("7.23076");

    mockMvc.perform(get("/api/v1/")//
        .param("x", "18.8") //
        .param("y", "2.6") //
        .param("operation", "div")) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("div")) //
        .andExpect(jsonPath("$.result").value("7.23076")) //
        .andDo(print());
  }

  // ------------------------------------------------------------

  @Test
  void testAdd3() throws Exception {

    InputDTO input = InputDTO.builder() //
        .x("18.8") //
        .y("2.6") //
        .operation("add") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonInput = objectMapper.writeValueAsString(input);

    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "add")).thenReturn("21.4");

    mockMvc.perform(post("/api/v1/") //
        .contentType(MediaType.APPLICATION_JSON) //
        .content(jsonInput)) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("add")) //
        .andExpect(jsonPath("$.result").value("21.4")) //
        .andDo(print());
  }

  @Test
  void testSub3() throws Exception {

    InputDTO input = InputDTO.builder() //
        .x("18.8") //
        .y("2.6") //
        .operation("sub") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonInput = objectMapper.writeValueAsString(input);

    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "sub")).thenReturn("16.2");

    mockMvc.perform(post("/api/v1/") //
        .contentType(MediaType.APPLICATION_JSON) //
        .content(jsonInput)) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("sub")) //
        .andExpect(jsonPath("$.result").value("16.2")) //
        .andDo(print());
  }

  @Test
  void testMul3() throws Exception {

    InputDTO input = InputDTO.builder() //
        .x("18.8") //
        .y("2.6") //
        .operation("mul") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonInput = objectMapper.writeValueAsString(input);

    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "mul")).thenReturn("48.88");

    mockMvc.perform(post("/api/v1/") //
        .contentType(MediaType.APPLICATION_JSON) //
        .content(jsonInput)) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("mul")) //
        .andExpect(jsonPath("$.result").value("48.88")) //
        .andDo(print());
  }

  @Test
  void testDiv3() throws Exception {

    InputDTO input = InputDTO.builder() //
        .x("18.8") //
        .y("2.6") //
        .operation("div") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonInput = objectMapper.writeValueAsString(input);

    Mockito.when(exerciseService.calculatorE("18.8", "2.6", "div")).thenReturn("7.23076");

    mockMvc.perform(post("/api/v1/") //
        .contentType(MediaType.APPLICATION_JSON) //
        .content(jsonInput)) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.x").value("18.8")) //
        .andExpect(jsonPath("$.y").value("2.6")) //
        .andExpect(jsonPath("$.operation").value("div")) //
        .andExpect(jsonPath("$.result").value("7.23076")) //
        .andDo(print());
  }
}
