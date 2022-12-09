package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;

import java.util.List;
import java.util.Optional;

public interface RatePlanService {

    RatePlan save(RatePlan ratePlan);

    RatePlan update(RatePlan ratePlan);

    List<RatePlan> findAll();

    Optional<RatePlan> findById(Long id);

    void delete(Long id);
}
