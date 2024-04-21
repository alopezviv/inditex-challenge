package com.inditex.challenge.infrastructure.price.repository.h2.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
@Entity

@Table(name = "prices")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand_id")
    private Integer brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private Integer priceList;
    @Column(name = "product_id")
    private Integer productId;
    private Integer priority;
    private Float price;
    private String curr;
}
