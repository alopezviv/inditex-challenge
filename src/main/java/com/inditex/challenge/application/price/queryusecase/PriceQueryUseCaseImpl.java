package com.inditex.challenge.application.price.queryusecase;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelInput;
import com.inditex.challenge.application.price.querymodels.PriceQueryModelOutput;
import com.inditex.challenge.domain.price.IPriceRepository;
import com.inditex.challenge.domain.price.Price;
import com.inditex.challenge.domain.price.exceptions.PriceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceQueryUseCaseImpl implements IPriceQueryUseCase{
    private ObjectMapper objectMapper;
    private IPriceRepository iPriceRepository;
    @Autowired
    public PriceQueryUseCaseImpl(IPriceRepository iPriceRepository, ObjectMapper objectMapper) {
        this.iPriceRepository = iPriceRepository;
        this.objectMapper = objectMapper;
    }



    @Override
    public PriceQueryModelOutput getPrice(PriceQueryModelInput priceQueryModelInput,    LocalDateTime applicationDate) {
        List<Price> filteredPrices = iPriceRepository.getPricesByDateProductIdAndBrandId(
                applicationDate, priceQueryModelInput.productId(), priceQueryModelInput.brandId());
        if(filteredPrices.isEmpty()){
            throw new PriceNotFoundException(priceQueryModelInput.toString());
        }

        return objectMapper.convertValue(filteredPrices.get(0),PriceQueryModelOutput.class);
    }
}
