package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel update(Hotel hotel);

    List<Hotel> getAll();

    Optional<Hotel> getById(Long id);

    void delete(Long id);
}
