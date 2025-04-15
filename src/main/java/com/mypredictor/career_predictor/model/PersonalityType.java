package com.mypredictor.career_predictor.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PersonalityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    @ManyToMany
    @JoinTable(
        name = "personality_career_mapping",
        joinColumns = @JoinColumn(name = "personality_type_id"),
        inverseJoinColumns = @JoinColumn(name = "career_option_id")
    )
    private List<CareerOption> suitableCareerOptions = new ArrayList<>();
    
    // Default constructor
    public PersonalityType() {}
    
    // Constructor with fields
    public PersonalityType(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<CareerOption> getSuitableCareerOptions() {
        return suitableCareerOptions;
    }
    
    public void setSuitableCareerOptions(List<CareerOption> suitableCareerOptions) {
        this.suitableCareerOptions = suitableCareerOptions;
    }
    
    public void addCareerOption(CareerOption careerOption) {
        suitableCareerOptions.add(careerOption);
    }
}