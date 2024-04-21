package com.inditex.challenge.infrastructure.price.repository.h2;

import com.inditex.challenge.domain.price.Price;
import com.inditex.challenge.infrastructure.price.repository.h2.entities.PriceEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PriceRepositoryH2Dao extends JpaRepository<PriceEntity, Long> {
    @Query("select p from PriceEntity p where p.brandId = ?1 and p.productId = ?2 and p.startDate <= ?3 and p.endDate >= ?3")
    List<PriceEntity> findByBrandIdProductIdtAndApplicationDate(Integer brandId, Integer productId, LocalDateTime applicationDate, Sort sort);
}
