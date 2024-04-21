package com.inditex.challenge.infrastructure.price.api;

import com.inditex.challenge.application.price.queryusecase.IPriceQueryUseCase;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceRestControllerTest.class)
class PriceRestControllerTest {
     @Autowired
     private MockMvc mockMvc;
     @MockBean IPriceQueryUseCase iPriceQueryUseCase;


    @Test
    void getPrice() throws Exception {
        mockMvc.perform(get("http://localhost:8080/price")
                .param("applicationDate", "2020-06-14-00.00.00")
                .param("brandId","1")
                .param("productId", "1")
                .accept(MediaType.APPLICATION_JSON));

    }
}