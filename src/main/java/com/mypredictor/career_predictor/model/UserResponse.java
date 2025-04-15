package com.mypredictor.career_predictor.model;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ElementCollection
    @CollectionTable(name = "user_answers", 
                   joinColumns = @JoinColumn(name = "user_response_id"))
    @MapKeyColumn(name = "question_id")
    @Column(name = "answer_value")
    private Map<Long, Integer> answers = new HashMap<>();
    
    @ManyToOne
    @JoinColumn(name = "personality_type_id")
    private PersonalityType predictedPersonalityType;
    
    @ManyToOne
    @JoinColumn(name = "career_option_id")
    private CareerOption predictedCareerOption;
    
    // Default constructor
    public UserResponse() {}
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Map<Long, Integer> getAnswers() {
        return answers;
    }
    
    public void setAnswers(Map<Long, Integer> answers) {
        this.answers = answers;
    }
    
    public PersonalityType getPredictedPersonalityType() {
        return predictedPersonalityType;
    }
    
    public void setPredictedPersonalityType(PersonalityType predictedPersonalityType) {
        this.predictedPersonalityType = predictedPersonalityType;
    }
    
    public CareerOption getPredictedCareerOption() {
        return predictedCareerOption;
    }
    
    public void setPredictedCareerOption(CareerOption predictedCareerOption) {
        this.predictedCareerOption = predictedCareerOption;
    }
    
    public void addAnswer(Long questionId, Integer value) {
        answers.put(questionId, value);
    }
}