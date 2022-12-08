package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;

import java.util.List;
import java.util.Optional;

public interface HotelInventoryService {

    HotelInventory save(HotelInventory inventory);

    HotelInventory update(HotelInventory inventory);

    List<HotelInventory> findAll();

    Optional<HotelInventory> findById(Long id);

    void delete(Long id);
}
