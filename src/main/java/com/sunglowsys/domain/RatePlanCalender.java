package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class RatePlanCalender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private Double single_occupancy;

    @Column(nullable = false)
    private Double double_occupancy;

    @Column(nullable = false)
    private Double extra_adult_price;

    @Column(nullable = false)
    private Double extra_child_price;

    @Column(nullable = false)
    private Integer applicable_days;

    @ManyToOne(optional = false)
    private Hotel hotel;

    @ManyToOne(optional = false)
    private RatePlan ratePlan;

    public RatePlanCalender(LocalDate date, Double single_occupancy, Double double_occupancy, Double extra_adult_price, Double extra_child_price, Integer applicable_days, Hotel hotel, RatePlan ratePlan) {
        this.date = date;
        this.single_occupancy = single_occupancy;
        this.double_occupancy = double_occupancy;
        this.extra_adult_price = extra_adult_price;
        this.extra_child_price = extra_child_price;
        this.applicable_days = applicable_days;
        this.hotel = hotel;
        this.ratePlan = ratePlan;
    }
}
