package com.inditex.challenge.infrastructure.price.repository.h2;

import com.inditex.challenge.application.price.queryusecase.IPriceQueryUseCase;
import com.inditex.challenge.domain.IPriceRepository;
import com.inditex.challenge.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PriceRepositoryH2Impl implements IPriceRepository {
    private IPriceQueryUseCase iPriceQueryUseCase;
    @Autowired
    public PriceRepositoryH2Impl(IPriceQueryUseCase iPriceQueryUseCase) {
        this.iPriceQueryUseCase = iPriceQueryUseCase;
    }

    @Override
    public Price getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return null;
    }
}
