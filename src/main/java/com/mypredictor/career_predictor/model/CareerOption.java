package com.mypredictor.career_predictor.model;

import jakarta.persistence.*;

@Entity
public class CareerOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String requirements;
    private String outlookDescription;
    
    // Default constructor
    public CareerOption() {}
    
    // Constructor with fields
    public CareerOption(String name, String description, String requirements, String outlookDescription) {
        this.name = name;
        this.description = description;
        this.requirements = requirements;
        this.outlookDescription = outlookDescription;
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
    
    public String getRequirements() {
        return requirements;
    }
    
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    
    public String getOutlookDescription() {
        return outlookDescription;
    }
    
    public void setOutlookDescription(String outlookDescription) {
        this.outlookDescription = outlookDescription;
    }
}