package com.candenizgumus.springbootquizapp.exceptions;

import lombok.Getter;


@Getter


public class QuizAppException extends RuntimeException
{
    private ErrorType errorType;

    public QuizAppException(ErrorType errorType)
    {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public QuizAppException(ErrorType errorType, String customMessage)
    {
        super(customMessage);
        this.errorType = errorType;
    }
}
