package com.sunglowsys.service.impl;

import com.sunglowsys.domain.InventoryCalender;
import com.sunglowsys.repository.InventoryCalenderRepository;
import com.sunglowsys.service.InventoryCalenderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryCalenderServiceImpl implements InventoryCalenderService {

    private final InventoryCalenderRepository calenderRepository;

    public InventoryCalenderServiceImpl(InventoryCalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    @Override
    public InventoryCalender save(InventoryCalender inventoryCalender) {
        return calenderRepository.save(inventoryCalender);
    }

    @Override
    public List<InventoryCalender> saveAll(List<InventoryCalender> calenders) {
        return calenderRepository.saveAll(calenders);
    }

    @Override
    public InventoryCalender update(InventoryCalender inventoryCalender) {
        return calenderRepository.save(inventoryCalender);
    }

    @Override
    public List<InventoryCalender> findAll() {
        return calenderRepository.findAll();
    }

    @Override
    public Optional<InventoryCalender> findById(Long id) {
        return calenderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        calenderRepository.deleteById(id);
    }
}
