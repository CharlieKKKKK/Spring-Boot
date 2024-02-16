package com.vtxlab.bootcamp.springboot_exercise_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.bootcamp.springboot_exercise_1.infra.ApiResponse;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.DivideByZeroException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.InvalidInputException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.InvalidOperaException;
import com.vtxlab.bootcamp.springboot_exercise_1.infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DivideByZeroException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> DivideByZeroExceptionHandler(DivideByZeroException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.DIVID_BY_ZERO.getCode()) //
        .message(Syscode.DIVID_BY_ZERO.getMessage()) //
        .build();
  }

  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> InvalidInputExceptionHandler(InvalidInputException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.INVALID_INPUT.getCode()) //
        .message(Syscode.INVALID_INPUT.getMessage()) //
        .build();
  }

  @ExceptionHandler(InvalidOperaException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> InvalidOperaExceptionHandler(InvalidOperaException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.INVALID_OPERA.getCode()) //
        .message(Syscode.INVALID_OPERA.getMessage()) //
        .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> npeExceptionHandler(NullPointerException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.NPE_EXCEPTION.getCode()) //
        .message(Syscode.NPE_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> ExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.GENERAL_EXCEPTION.getCode()) //
        .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
        .build();
  }

}
