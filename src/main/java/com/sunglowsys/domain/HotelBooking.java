package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate bookingDate;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private Integer noOfAdult;

    private Integer noOfChild;

    @Column(nullable = false)
    private Integer totalGuest;

    @Column(nullable = false)
    private Integer noOfRoom;

    @Column(nullable = false)
    private Integer noOfNight;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private Hotel hotel;

    @ManyToOne(optional = false)
    private RoomType roomType;

    @ManyToOne(optional = false)
    private RatePlan ratePlan;

    public HotelBooking(LocalDate checkInDate, LocalDate checkOutDate, Integer noOfAdult, Integer noOfChild, Integer noOfRoom, Integer noOfNight, Customer customer, Hotel hotel, RoomType roomType, RatePlan ratePlan) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfAdult = noOfAdult;
        this.noOfChild = noOfChild;
        this.noOfRoom = noOfRoom;
        this.noOfNight = noOfNight;
        this.customer = customer;
        this.hotel = hotel;
        this.roomType = roomType;
        this.ratePlan = ratePlan;
    }
}
