package com.sunglowsys.repository;

import com.sunglowsys.domain.InventoryCalender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryCalenderRepository extends JpaRepository<InventoryCalender, Long> {
}
