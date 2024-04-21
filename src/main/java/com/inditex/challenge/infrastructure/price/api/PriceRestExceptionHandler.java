package com.inditex.challenge.infrastructure.price.api;

import com.inditex.challenge.domain.price.exceptions.PriceNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PriceRestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex){
        return new ResponseEntity<>(String.format("Search with data: %s does not find any price", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
