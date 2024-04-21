package com.inditex.challenge.infrastructure.price.repository.h2;


import com.inditex.challenge.domain.price.IPriceRepository;


import com.inditex.challenge.domain.price.Price;
import com.inditex.challenge.infrastructure.price.repository.h2.entities.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryH2Impl implements IPriceRepository {
    PriceRepositoryH2Dao priceRepositoryH2Dao;

    @Autowired
    public PriceRepositoryH2Impl(PriceRepositoryH2Dao priceRepositoryH2Dao) {
        this.priceRepositoryH2Dao = priceRepositoryH2Dao;
    }

    @Override
    public List<Price> getPricesByDateProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceRepositoryH2Dao.findByBrandIdProductIdtAndApplicationDate(brandId, productId, applicationDate, Sort.by(Sort.Direction.DESC, "priority"))
                .stream()
                .map(this::parsePriceEntityToPrice)
                .toList();
    }
    private Price parsePriceEntityToPrice(PriceEntity priceEntity){
        return new Price(
                priceEntity.getBrandId(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPriceList(),
                priceEntity.getProductId(),
                priceEntity.getPriority(),
                priceEntity.getPrice(),
                priceEntity.getCurr()
        );
    }
}
