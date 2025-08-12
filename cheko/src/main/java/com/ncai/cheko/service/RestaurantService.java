package com.ncai.cheko.service;

import com.ncai.cheko.entity.Restaurant;
import com.ncai.cheko.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Cacheable("locations")
    public List<Restaurant> getAllLocations() {
        return restaurantRepository.findAll();
    }
}
