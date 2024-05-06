package com.candenizgumus.springbootquizapp.exceptions;

// Bu sınıf tüm controller sınıfları için merkezi bir şekilde hata yönetimi sağlayacaktır.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(QuizAppException.class)
    public ResponseEntity<ErrorMessage> handleDemoException(QuizAppException ex){
        ErrorType errorType = ex.getErrorType();
        return new ResponseEntity(createErrorMessage(ex),errorType.getStatus());
    }

    private ErrorMessage createErrorMessage(QuizAppException ex)
    {
       return ErrorMessage.builder().code(ex.getErrorType().getCode()).message(ex.getMessage()).build();
    }

    /**
     * Exception'ı yakalar ve gerekli parametreleri alarak kullanıcıyı bilgilendirir.
     * @param ex Yakalanmak istenen exception.
     * @return hata bilgilerini döndürür.
     */
    @ExceptionHandler(RuntimeException.class) // Hata yakalayici bir metod olduğunu belirtmek için.
    public ResponseEntity<String> handleException(RuntimeException ex){
       return ResponseEntity.badRequest().body(ex.getMessage());
    }


    /**
     * Exception'ı yakalar ve gerekli parametreleri alarak kullanıcıyı bilgilendirir.
     * @param ex Yakalanmak istenen exception.
     * @return hata bilgilerini döndürür.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleException2(MethodArgumentNotValidException ex){
        Map<String,String > error = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(errors -> {
            String fieldName = ((FieldError) errors ).getField();
            String errorMessage = errors.getDefaultMessage();
            error.put(fieldName,errorMessage);
        });

        return error;
    }
}
