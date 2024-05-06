package com.candenizgumus.springbootquizapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  QUESTION_NOT_FOUND(5001,"Böyle bir Question bulunamadı", HttpStatus.NOT_FOUND),
  ANSWER_NOT_FOUND(5002,"Böyle bir Answer bulunamadı", HttpStatus.NOT_FOUND),
  CORRECTANSWER_NOT_FOUND(5003,"Böyle bir Correct Answer bulunamadı", HttpStatus.NOT_FOUND),
  QUIZ_NOT_FOUND(5004,"Böyle bir Quiz bulunamadı", HttpStatus.NOT_FOUND);



  private Integer code;
  private String message;
  private HttpStatus status;
}
