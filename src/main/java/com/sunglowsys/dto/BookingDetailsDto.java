package com.sunglowsys.dto;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.domain.RoomType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class BookingDetailsDto {

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String gender;

    private Integer age;

    private String idType;

    private String idNumber;

    // Booking Details

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Integer noOfAdult;

    private Integer noOfChild;

    private Integer noOfRoom;

    private Integer noOfNight;

    private Hotel hotel;

    private RoomType roomType;

    private RatePlan ratePlan;

    public BookingDetailsDto(String lastName, String email, String mobile, String gender, Integer age, String idType, String idNumber, LocalDate checkInDate, LocalDate checkOutDate, Integer noOfAdult, Integer noOfChild, Integer noOfRoom, Integer noOfNight, Hotel hotel, RoomType roomType, RatePlan ratePlan) {
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.age = age;
        this.idType = idType;
        this.idNumber = idNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfAdult = noOfAdult;
        this.noOfChild = noOfChild;
        this.noOfRoom = noOfRoom;
        this.noOfNight = noOfNight;
        this.hotel = hotel;
        this.roomType = roomType;
        this.ratePlan = ratePlan;
    }
}
