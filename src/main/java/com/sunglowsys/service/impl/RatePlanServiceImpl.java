package com.sunglowsys.service.impl;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.domain.RatePlanCalender;
import com.sunglowsys.repository.RatePlanRepository;
import com.sunglowsys.service.RatePlanCalenderService;
import com.sunglowsys.service.RatePlanService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatePlanServiceImpl implements RatePlanService {

    private final RatePlanRepository ratePlanRepository;
    private final RatePlanCalenderService planCalenderService;
    public RatePlanServiceImpl(RatePlanRepository ratePlanRepository, RatePlanCalenderService planCalenderService) {
        this.ratePlanRepository = ratePlanRepository;
        this.planCalenderService = planCalenderService;
    }

    @Override
    public RatePlan save(RatePlan ratePlan) {
        RatePlan result =  ratePlanRepository.save(ratePlan);
        planCalenderService.saveAll(generatePlanCalender(result));
        return result;
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

    /*
    * Generate Rate Plan Calender
    * */
    private List<RatePlanCalender> generatePlanCalender(RatePlan ratePlan) {
        List<RatePlanCalender> calenders = new ArrayList<>();
        for (int i = 0; i < 365; i++) {
            calenders.add(new RatePlanCalender(LocalDate.now().plusDays(i),2000.0, 3500.0,
                    1000.0, 500.0, 1, ratePlan.getHotel(), ratePlan));
        }
        return calenders;
    }
}
