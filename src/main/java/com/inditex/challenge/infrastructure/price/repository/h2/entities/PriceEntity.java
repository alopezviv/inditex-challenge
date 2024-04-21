package com.inditex.challenge.infrastructure.price.repository.h2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "prices")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private Float price;
    private String curr;
}
