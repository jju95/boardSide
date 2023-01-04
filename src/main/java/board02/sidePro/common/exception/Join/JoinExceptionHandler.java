package board02.sidePro.common.exception.Join;

import board02.sidePro.common.exception.ErrorResponse;
import board02.sidePro.common.exception.Join.customException.AlreadyUserNickNameException;
import board02.sidePro.common.exception.Join.customException.AlreadyUserException;
import board02.sidePro.common.exception.Join.customException.NotSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class JoinExceptionHandler {

    @ExceptionHandler(AlreadyUserException.class)
    public ResponseEntity<ErrorResponse> handlerAlreadyUserException(AlreadyUserException ex){
        log.error("handlerAlreadyUserException",ex.getErrorCode());
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response , HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(AlreadyUserNickNameException.class)
    public ResponseEntity<ErrorResponse> handlerAlreadyUserNickNameException(AlreadyUserNickNameException ex){
        log.error("handlerAlreadyUserNickNameException",ex.getErrorCode());
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response , HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotSuchElementException.class)
    public ResponseEntity<ErrorResponse> handlerNotSuchElementException(NotSuchElementException ex){
        log.error("handlerNotSuchElementException",ex.getErrorCode());
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }
}