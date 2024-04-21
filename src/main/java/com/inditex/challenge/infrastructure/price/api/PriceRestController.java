package com.inditex.challenge.infrastructure.price.api;

import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import com.inditex.challenge.application.price.queryusecase.IPriceQueryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceRestController {
    IPriceQueryUseCase iPriceQueryUseCase;
    @Autowired
    public PriceRestController(IPriceQueryUseCase iPriceQueryUseCase) {
        this.iPriceQueryUseCase = iPriceQueryUseCase;
    }

    @GetMapping("")
    public PriceQueryModelOutput getPrice(PriceQueryModelInput priceQueryModelInput,
                                          @RequestParam(required = true)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate){
        return iPriceQueryUseCase.getPrice(priceQueryModelInput, applicationDate);
    }
}
