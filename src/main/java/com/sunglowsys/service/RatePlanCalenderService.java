package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlanCalender;

import java.util.List;
import java.util.Optional;

public interface RatePlanCalenderService {

    RatePlanCalender save(RatePlanCalender planCalender);

    List<RatePlanCalender> saveAll(List<RatePlanCalender> planCalenders);

    RatePlanCalender update(RatePlanCalender planCalender);

    List<RatePlanCalender> findAll();

    Optional<RatePlanCalender> findById(Long id);

    void delete(Long id);
}
