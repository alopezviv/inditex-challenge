package com.inditex.challenge.domain;

import java.time.LocalDateTime;
import java.util.Currency;

public record Price(
        Integer brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer priceList,
        Integer productId,
        Integer priority,
        Float price,
        String curr
) {
}
