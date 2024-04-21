package com.inditex.challenge.application.price.querymodels;

import java.time.LocalDateTime;

public record PriceQueryModelInput(
    Integer productId,
    Integer brandId
) {
}
