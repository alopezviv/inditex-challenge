package com.inditex.challenge.infrastructure.price.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import com.inditex.challenge.application.price.queryusecase.IPriceQueryUseCase;
import com.inditex.challenge.domain.price.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceRestController.class)
class PriceRestControllerTest {
     @Autowired
     private MockMvc mockMvc;
     @MockBean
     private IPriceQueryUseCase iPriceQueryUseCase;
     ObjectMapper objectMapper;
    PriceQueryModelInput priceQueryModelInput;
    PriceQueryModelOutput priceQueryModelOutput;
    @BeforeEach
    void setUp(){
        LocalDateTime actualDate = LocalDateTime.now();
        priceQueryModelInput = new PriceQueryModelInput(1,1);
        priceQueryModelOutput = new PriceQueryModelOutput(1, actualDate,actualDate,1,1,1.0f,"EUR");
        objectMapper = new ObjectMapper().findAndRegisterModules().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    @Test
    void getPrice() throws Exception {
        when(iPriceQueryUseCase.getPrice(any(),any())).thenReturn(priceQueryModelOutput);
        var result = mockMvc.perform(get("/price")
                .param("applicationDate", "2020-06-14T00:00:00.000")
                .param("brandId","1")
                .param("productId", "35455")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        PriceQueryModelOutput resultPrice =  objectMapper.readValue(result.getContentAsString(),PriceQueryModelOutput.class);
        assertEquals(resultPrice,priceQueryModelOutput);
    }
}