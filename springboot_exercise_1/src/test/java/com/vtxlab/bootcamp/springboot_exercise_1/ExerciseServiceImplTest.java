package com.vtxlab.bootcamp.springboot_exercise_1;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.vtxlab.bootcamp.springboot_exercise_1.infra.DivideByZeroException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.InvalidInputException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.InvalidOperaException;
//import com.vtxlab.bootcamp.springboot_exercise_1.service.impl.ExerciseServiceImpl;
import com.vtxlab.bootcamp.springboot_exercise_1.service.ExerciseService;
import com.vtxlab.bootcamp.springboot_exercise_1.service.impl.ExerciseServiceImpl;

@WebMvcTest(ExerciseService.class)
public class ExerciseServiceImplTest {

  @Autowired
  private ExerciseService exerciseService;

  @Test
  void testcalculatorE() {

    // ExerciseService exerciseService = new ExerciseServiceImpl();

    // Add
    String testAdd = exerciseService.calculatorE("10.6", "2.0", "add");
    assertThat(testAdd, equalTo("12.60000"));

    String testAdd2 = exerciseService.calculatorE("10.6", "-2.0", "add");
    assertThat(testAdd2, equalTo("8.60000"));

    String testAdd3 = exerciseService.calculatorE("-10.6", "2.0", "add");
    assertThat(testAdd3, equalTo("-8.60000"));

    String testAdd4 = exerciseService.calculatorE("-10.6", "-2.0", "add");
    assertThat(testAdd4, equalTo("-12.60000"));

    // Sub
    String testSub = exerciseService.calculatorE("10.6", "2.0", "sub");
    assertThat(testSub, equalTo("8.60000"));

    String testSub2 = exerciseService.calculatorE("10.6", "-2.0", "sub");
    assertThat(testSub2, equalTo("12.60000"));

    String testSub3 = exerciseService.calculatorE("-10.6", "2.0", "sub");
    assertThat(testSub3, equalTo("-12.60000"));

    String testSub4 = exerciseService.calculatorE("-10.6", "-2.0", "sub");
    assertThat(testSub4, equalTo("-8.60000"));

    // Mul
    String testMul = exerciseService.calculatorE("10.6", "2.0", "mul");
    assertThat(testMul, equalTo("21.20000"));

    String testMul2 = exerciseService.calculatorE("10.6", "-2.0", "mul");
    assertThat(testMul2, equalTo("-21.20000"));

    String testMul3 = exerciseService.calculatorE("-10.6", "2.0", "mul");
    assertThat(testMul3, equalTo("-21.20000"));

    String testMul4 = exerciseService.calculatorE("-10.6", "-2.0", "mul");
    assertThat(testMul4, equalTo("21.20000"));

    // Div
    String testDiv = exerciseService.calculatorE("10.6", "2.0", "div");
    assertThat(testDiv, equalTo("5.30000"));

    String testDiv2 = exerciseService.calculatorE("10.6", "-2.0", "div");
    assertThat(testDiv2, equalTo("-5.30000"));

    String testDiv3 = exerciseService.calculatorE("-10.6", "2.0", "div");
    assertThat(testDiv3, equalTo("-5.30000"));

    String testDiv4 = exerciseService.calculatorE("-10.6", "-2.0", "div");
    assertThat(testDiv4, equalTo("5.30000"));

  }

  @Test
  void testDivideByZeroException() {
    assertThrows(DivideByZeroException.class, () -> {
      new ExerciseServiceImpl().calculatorE("10.6", "0", "div");
    });
  }

  @Test
  void testInvalidInputException() {
    assertThrows(InvalidInputException.class, () -> {
      new ExerciseServiceImpl().calculatorE("10.6", "ABC", "div");
    });
  }

  @Test
  void testInvalidOperaException() {
    assertThrows(InvalidOperaException.class, () -> {
      new ExerciseServiceImpl().calculatorE("10.6", "2.6", "ABC");
    });
  }
}
