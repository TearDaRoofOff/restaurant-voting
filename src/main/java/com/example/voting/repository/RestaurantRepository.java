package com.example.voting.repository;

import com.example.voting.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByName(@Param("name") String name);

    @Override
    @Secured({"ROLE_ADMIN"})
    Restaurant save(Restaurant entity);
}