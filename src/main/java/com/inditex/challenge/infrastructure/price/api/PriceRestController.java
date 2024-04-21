package com.inditex.challenge.infrastructure.price.api;

import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import com.inditex.challenge.application.price.queryusecase.IPriceQueryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceRestController {
    IPriceQueryUseCase iPriceQueryUseCase;
    @Autowired
    public PriceRestController(IPriceQueryUseCase iPriceQueryUseCase) {
        this.iPriceQueryUseCase = iPriceQueryUseCase;
    }

    @GetMapping("")
    public PriceQueryModelOutput getPrice(PriceQueryModelInput priceQueryModelInput){
        return iPriceQueryUseCase.getPrice(priceQueryModelInput);
    }
}
