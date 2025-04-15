package com.mypredictor.career_predictor.model;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String text;
    
    // Numeric value for ML processing (e.g., 1-5 scale)
    private Integer value;
    
    // Default constructor
    public Answer() {}
    
    // Constructor with fields
    public Answer(String text, Integer value) {
        this.text = text;
        this.value = value;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
}