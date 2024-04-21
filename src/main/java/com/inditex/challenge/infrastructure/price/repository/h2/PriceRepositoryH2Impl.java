package com.inditex.challenge.infrastructure.price.repository.h2;

import com.inditex.challenge.domain.price.IPriceRepository;
import com.inditex.challenge.domain.price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryH2Impl implements IPriceRepository {
    @Autowired
    public PriceRepositoryH2Impl() {

    }

    @Override
    public List<Price> getPricesByDateProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return null;
    }
}
