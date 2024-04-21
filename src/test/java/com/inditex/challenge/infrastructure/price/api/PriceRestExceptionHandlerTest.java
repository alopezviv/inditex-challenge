package com.inditex.challenge.infrastructure.price.api;

import com.inditex.challenge.domain.price.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class PriceRestExceptionHandlerTest {

    private PriceRestExceptionHandler priceRestExceptionHandler;
    @BeforeEach
    void setUp(){
        priceRestExceptionHandler = new PriceRestExceptionHandler();
    }
    @Test
    void handlePriceNotFoundException() {
        PriceNotFoundException priceNotFoundException = new PriceNotFoundException("any");
        ResponseEntity<Object> result = priceRestExceptionHandler.handlePriceNotFoundException(priceNotFoundException);
        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(result.getBody(), "Search with data: any does not find any price");
    }
}