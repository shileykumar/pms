package com.sunglowsys.service.impl;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.domain.InventoryCalender;
import com.sunglowsys.repository.HotelInventoryRepository;
import com.sunglowsys.service.HotelInventoryService;
import com.sunglowsys.service.InventoryCalenderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelInventoryServiceImpl implements HotelInventoryService {

    private final HotelInventoryRepository inventoryRepository;

    private final InventoryCalenderService calenderService;

    public HotelInventoryServiceImpl(HotelInventoryRepository inventoryRepository, InventoryCalenderService calenderService) {
        this.inventoryRepository = inventoryRepository;
        this.calenderService = calenderService;
    }

    @Override
    public HotelInventory save(HotelInventory inventory) {
        HotelInventory result = inventoryRepository.save(inventory);
        calenderService.saveAll(generateCalender(result));
        return result;
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

    /*
    * Generate Inventory Calender
    * */
    private List<InventoryCalender> generateCalender(HotelInventory inventory) {

        List<InventoryCalender> calenders = new ArrayList<>();
        LocalDate date = LocalDate.now();
        for (int i = 0; i <= 365; i++) {
            calenders.add(new InventoryCalender(date.plusDays(i), inventory.getTotalInventory(),
                    0, 0, inventory.getHotel(), inventory.getRoomType()));
        }
        return calenders;
    }
}
