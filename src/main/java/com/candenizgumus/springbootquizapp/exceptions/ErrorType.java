package com.candenizgumus.springbootquizapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  QUESTION_NOT_FOUND(5001,"Böyle bir Question bulunamadı", HttpStatus.NOT_FOUND);



  private Integer code;
  private String message;
  private HttpStatus status;
}
