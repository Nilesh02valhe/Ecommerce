package com.Nil.Electronic.Shop.exception;

import com.Nil.Electronic.Shop.dto.ApiResponceMessage;
import com.Nil.Electronic.Shop.dto.ApiResponceMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalExceptionHandler {

    private Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponceMessage> resourceNotFoundExceptionHanEntity(ResourceNotFoundException ex){

        logger.info("Exception Handle Invoke !!");
        ApiResponceMessage responce = ApiResponceMessage.builder()
//                .massage(ex.getMessage())
//                .status(HttpStatus.NOT_FOUND)
//                .Success(true)
                .build();

        return new ResponseEntity(responce, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        Map<String, Object> response= new HashMap<>();
        allErrors.stream().forEach(ObjectError->{
            String Message = ObjectError.getDefaultMessage();
            String field = ((FieldError)ObjectError).getField();
            response.put(field, Message);
        });
        return new ResponseEntity<> (response,HttpStatus.BAD_REQUEST);
    }

}
