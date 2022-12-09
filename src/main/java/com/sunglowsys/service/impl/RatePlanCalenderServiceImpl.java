package com.sunglowsys.service.impl;

import com.sunglowsys.domain.RatePlanCalender;
import com.sunglowsys.repository.RatePlanCalenderRepository;
import com.sunglowsys.service.RatePlanCalenderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatePlanCalenderServiceImpl implements RatePlanCalenderService {

    private final RatePlanCalenderRepository calenderRepository;

    public RatePlanCalenderServiceImpl(RatePlanCalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    @Override
    public RatePlanCalender save(RatePlanCalender planCalender) {
        return calenderRepository.save(planCalender);
    }

    @Override
    public List<RatePlanCalender> saveAll(List<RatePlanCalender> planCalenders) {
        return calenderRepository.saveAll(planCalenders);
    }

    @Override
    public RatePlanCalender update(RatePlanCalender planCalender) {
        return calenderRepository.save(planCalender);
    }

    @Override
    public List<RatePlanCalender> findAll() {
        return calenderRepository.findAll();
    }

    @Override
    public Optional<RatePlanCalender> findById(Long id) {
        return calenderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        calenderRepository.deleteById(id);
    }
}
