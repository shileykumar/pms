package com.sunglowsys.service.impl;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.repository.RatePlanRepository;
import com.sunglowsys.service.RatePlanService;

import java.util.List;
import java.util.Optional;

public class RatePlanServiceImpl implements RatePlanService {

    private final RatePlanRepository ratePlanRepository;

    public RatePlanServiceImpl(RatePlanRepository ratePlanRepository) {
        this.ratePlanRepository = ratePlanRepository;
    }

    @Override
    public RatePlan save(RatePlan ratePlan) {
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public RatePlan update(RatePlan ratePlan) {
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public List<RatePlan> findAll() {
        return ratePlanRepository.findAll();
    }

    @Override
    public Optional<RatePlan> findById(Long id) {
        return ratePlanRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        ratePlanRepository.deleteById(id);
    }
}
