package com.sunglowsys.repository;

import com.sunglowsys.domain.RatePlanCalender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatePlanCalenderRepository extends JpaRepository<RatePlanCalender, Long> {
}
