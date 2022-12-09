package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class InventoryCalender implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate inventoryDate;

    @Column(nullable = false)
    private Integer available;

    private Integer sold;

    private Integer block;

    @ManyToOne(optional = false)
    private Hotel hotel;

    @ManyToOne(optional = false)
    private RoomType roomType;

    public InventoryCalender(LocalDate inventoryDate, Integer available, Integer sold, Integer block, Hotel hotel, RoomType roomType) {
        this.inventoryDate = inventoryDate;
        this.available = available;
        this.sold = sold;
        this.block = block;
        this.hotel = hotel;
        this.roomType = roomType;
    }
}
