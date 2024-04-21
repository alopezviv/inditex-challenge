package com.inditex.challenge.application.price.queryusecase;

import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;

import java.time.LocalDateTime;

public interface IPriceQueryUseCase {
    PriceQueryModelOutput getPrice(PriceQueryModelInput priceQueryModelInput,    LocalDateTime applicationDate);
}
