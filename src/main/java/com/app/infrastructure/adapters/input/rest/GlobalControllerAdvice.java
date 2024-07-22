package com.app.infrastructure.adapters.input.rest;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.domain.exception.StudentNotFoundException;
import com.app.domain.model.ErrorResponse;

import static com.app.utils.ErrorCatalog.GENERIC_ERROR;
import static com.app.utils.ErrorCatalog.INVALID_STUDENT;
import static com.app.utils.ErrorCatalog.STUDENT_NOT_FOUND;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerAdvice {

  private ErrorResponse buildErrorResponse(HttpStatus status, String message, List<String> details) {
    return ErrorResponse.builder()
            .code(String.valueOf(status.value()))
            .message(message)
            .details(details)
            .timestamp(LocalDateTime.now())
            .build();
  }

  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<?> handleStudentNotFoundException() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildErrorResponse(
            HttpStatus.NOT_FOUND,
            STUDENT_NOT_FOUND.getMessage(),
            Collections.emptyList()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    BindingResult result = exception.getBindingResult();
    List<String> details = result.getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());

    return ResponseEntity.badRequest().body(buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            INVALID_STUDENT.getMessage(),
            details));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGenericError(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            GENERIC_ERROR.getMessage(),
            Collections.singletonList(exception.getMessage())));
  }
}

