package com.mypredictor.career_predictor.repository;


import com.mypredictor.career_predictor.model.CareerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerOptionRepository extends JpaRepository<CareerOption, Long> {
    CareerOption findByName(String name);
}