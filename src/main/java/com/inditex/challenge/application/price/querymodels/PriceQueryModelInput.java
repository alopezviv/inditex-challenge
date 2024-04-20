package com.inditex.challenge.application.price.querymodels;

import java.time.LocalDateTime;

public record PriceQueryModelInput(
    LocalDateTime applicationDate,
    Integer productId,
    Integer brandId
) {
}
