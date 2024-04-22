package com.inditex.challenge.infrastructure.price.repository.h2;

import com.inditex.challenge.domain.price.Price;
import com.inditex.challenge.infrastructure.price.repository.h2.entities.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryH2ImplTest {
    @Mock
    PriceRepositoryH2Dao priceRepositoryH2Dao;
    PriceRepositoryH2Impl priceRepositoryH2UnderTest;
    Price price;
    PriceEntity priceEntity;
    @BeforeEach
    void setUp(){
        LocalDateTime actualDate = LocalDateTime.now();
        price = new Price(
                1, actualDate,actualDate,1,1,1,1.0f,"EUR"
        );
        priceEntity = new PriceEntity(
                1L,1, actualDate,actualDate,1,1,1,1.0f,"EUR"
        );
        priceRepositoryH2UnderTest = new PriceRepositoryH2Impl(priceRepositoryH2Dao);
    }
    @Test
    void getPricesByDateProductIdAndBrandId() {
        when(priceRepositoryH2Dao.findByBrandIdProductIdtAndApplicationDate(eq(1),eq(1), any(LocalDateTime.class),any(Sort.class))).thenReturn(List.of(priceEntity));
        List<Price> result = priceRepositoryH2UnderTest.getPricesByDateProductIdAndBrandId(LocalDateTime.now(),1,1);
        assertEquals(result.get(0),price);
    }
}