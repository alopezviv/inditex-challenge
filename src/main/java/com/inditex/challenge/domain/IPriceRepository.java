package com.inditex.challenge.domain;

import java.time.LocalDateTime;

public interface IPriceRepository {
    Price getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
