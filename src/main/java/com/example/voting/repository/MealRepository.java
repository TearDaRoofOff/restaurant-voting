package com.example.voting.repository;

import com.example.voting.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;

public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Override
    @Secured("ROLE_ADMIN")
    Meal save(Meal entity);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteById(Integer id);
}