package com.sunglowsys.service;

import com.sunglowsys.domain.InventoryCalender;

import java.util.List;
import java.util.Optional;

public interface InventoryCalenderService {

    InventoryCalender save(InventoryCalender inventoryCalender);

    List<InventoryCalender> saveAll(List<InventoryCalender> calenders);

    InventoryCalender update(InventoryCalender inventoryCalender);

    List<InventoryCalender> findAll();

    Optional<InventoryCalender> findById(Long id);

    void delete(Long id);
}
