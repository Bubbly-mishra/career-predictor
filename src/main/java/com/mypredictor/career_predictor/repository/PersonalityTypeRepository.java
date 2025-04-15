package com.mypredictor.career_predictor.repository;

import com.mypredictor.career_predictor.model.PersonalityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalityTypeRepository extends JpaRepository<PersonalityType, Long> {
    PersonalityType findByName(String name);
}
