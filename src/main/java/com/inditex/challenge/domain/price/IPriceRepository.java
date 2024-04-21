package com.inditex.challenge.domain.price;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceRepository {
    List<Price> getPricesByDateProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
