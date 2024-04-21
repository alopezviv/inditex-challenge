package com.inditex.challenge.application.price.queryusecase;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import com.inditex.challenge.domain.price.IPriceRepository;
import com.inditex.challenge.domain.price.Price;
import com.inditex.challenge.domain.price.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class PriceQueryUseCaseImplTest {
    @Mock
    IPriceRepository iPriceRepository;
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    IPriceQueryUseCase priceQueryUseCaseUnderTest;
    Price price;
    PriceQueryModelInput priceQueryModelInput;
    PriceQueryModelOutput priceQueryModelOutput;

    @BeforeEach
    void setUp(){
        LocalDateTime actualDate = LocalDateTime.now();
        price = new Price(
                1, actualDate,actualDate,1,1,1,1.0f,"EUR"
        );
        priceQueryModelInput = new PriceQueryModelInput(1,1);
        priceQueryModelOutput = new PriceQueryModelOutput(1, actualDate,actualDate,1,1,1.0f,"EUR");
        priceQueryUseCaseUnderTest = new PriceQueryUseCaseImpl(iPriceRepository, objectMapper);
    }
    @Test
    void getPrice() {
        when(iPriceRepository.getPricesByDateProductIdAndBrandId(any(),eq(1),eq(1))).thenReturn(List.of(price));
        assertEquals(priceQueryModelOutput, priceQueryUseCaseUnderTest.getPrice(priceQueryModelInput,LocalDateTime.now()));
    }
    @Test
    void getPrice_throwPriceNotFoundException() {
        when(iPriceRepository.getPricesByDateProductIdAndBrandId(any(),eq(1),eq(1))).thenReturn(List.of());
        assertThrows(PriceNotFoundException.class,()->priceQueryUseCaseUnderTest.getPrice(priceQueryModelInput,LocalDateTime.now()));

    }

}