package com.inditex.challenge.application.price.querymodels;

import java.time.LocalDateTime;

public record PriceQueryModelOutput(
        Integer brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer priceList,
        Integer productId,
        Float price,
        String curr
) {
}
