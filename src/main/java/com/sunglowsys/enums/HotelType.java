package com.sunglowsys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HotelType {
    ONE_STAR("One Star"),
    TWO_STAR("Two Star"),
    THREE_STAR("Three Star"),
    FOUR_STAR("Four Star"),
    FIVE_STAR("Five Star"),
    SIX_STAR("Six Star"),
    SEVEN_STAR("Seven Star");

    private String name;

}
