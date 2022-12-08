package com.sunglowsys.service.impl;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.repository.HotelInventoryRepository;
import com.sunglowsys.service.HotelInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelInventoryServiceImpl implements HotelInventoryService {

    private final HotelInventoryRepository inventoryRepository;

    public HotelInventoryServiceImpl(HotelInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public HotelInventory save(HotelInventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public HotelInventory update(HotelInventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<HotelInventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<HotelInventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }
}
