package com.inditex.challenge.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.challenge.ChallengeApplication;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ChallengeApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class PriceIntegrationTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPrice1() throws Exception {
        var result = mockMvc.perform(get("/price")
                .param("applicationDate", "2020-06-14T10:00:00.000")
                .param("brandId","1")
                .param("productId", "35455")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        PriceQueryModelOutput resultPrice =  objectMapper.readValue(result.getContentAsString(),PriceQueryModelOutput.class);
        assertEquals(1, resultPrice.priceList());
        assertEquals(35.50F, resultPrice.price());
    }
    @Test
    void getPrice2() throws Exception {
        var result = mockMvc.perform(get("/price")
                .param("applicationDate", "2020-06-14T16:00:00.000")
                .param("brandId","1")
                .param("productId", "35455")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        PriceQueryModelOutput resultPrice =  objectMapper.readValue(result.getContentAsString(),PriceQueryModelOutput.class);
        assertEquals(2, resultPrice.priceList());
        assertEquals(25.45F, resultPrice.price());
    }
    @Test
    void getPrice3() throws Exception {
        var result = mockMvc.perform(get("/price")
                .param("applicationDate", "2020-06-14T21:00:00.000")
                .param("brandId","1")
                .param("productId", "35455")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        PriceQueryModelOutput resultPrice =  objectMapper.readValue(result.getContentAsString(),PriceQueryModelOutput.class);
        assertEquals(1, resultPrice.priceList());
        assertEquals(35.50F, resultPrice.price());
    }
    @Test
    void getPrice4() throws Exception {
        var result = mockMvc.perform(get("/price")
                .param("applicationDate", "2020-06-15T10:00:00.000")
                .param("brandId","1")
                .param("productId", "35455")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        PriceQueryModelOutput resultPrice =  objectMapper.readValue(result.getContentAsString(),PriceQueryModelOutput.class);
        assertEquals(3, resultPrice.priceList());
        assertEquals(30.50F, resultPrice.price());
    }
    @Test
    void getPrice5() throws Exception {
        var result = mockMvc.perform(get("/price")
                .param("applicationDate", "2020-06-16T21:00:00.000")
                .param("brandId","1")
                .param("productId", "35455")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        PriceQueryModelOutput resultPrice =  objectMapper.readValue(result.getContentAsString(),PriceQueryModelOutput.class);
        assertEquals(4, resultPrice.priceList());
        assertEquals(38.95F, resultPrice.price());
    }

}
