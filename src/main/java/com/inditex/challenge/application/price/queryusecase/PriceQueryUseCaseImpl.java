package com.inditex.challenge.application.price.queryusecase;

import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import org.springframework.stereotype.Service;

@Service
public class PriceQueryUseCaseImpl implements IPriceQueryUseCase{
    @Override
    public PriceQueryModelOutput getPrice(PriceQueryModelInput priceQueryModelInput) {
        return null;
    }
}
