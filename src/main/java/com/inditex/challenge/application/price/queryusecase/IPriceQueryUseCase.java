package com.inditex.challenge.application.price.queryusecase;

import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;

public interface IPriceQueryUseCase {
    PriceQueryModelOutput getPrice(PriceQueryModelInput priceQueryModelInput);
}
