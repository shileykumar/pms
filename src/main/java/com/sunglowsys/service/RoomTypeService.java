package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;

import java.util.List;
import java.util.Optional;

public interface RoomTypeService {

    RoomType save(RoomType roomType);

    RoomType update(RoomType roomType);

    List<RoomType> findAll();

    Optional<RoomType> findById(Long id);

    void delete(Long id);
}
