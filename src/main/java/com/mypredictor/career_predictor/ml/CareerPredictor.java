package com.mypredictor.career_predictor.ml;

import org.springframework.stereotype.Component;
import smile.classification.RandomForest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CareerPredictor {
    
    private RandomForest model;
    
    // Maps personality types to common career options
    private static final Map<String, String[]> PERSONALITY_TO_CAREERS = new HashMap<>();
    
    static {
        PERSONALITY_TO_CAREERS.put("Analytical Thinker", 
            new String[]{"Data Scientist", "Software Engineer", "Financial Analyst", "Research Scientist"});
        
        PERSONALITY_TO_CAREERS.put("Creative Innovator", 
            new String[]{"UX Designer", "Marketing Creative", "Product Designer", "Content Creator"});
        
        PERSONALITY_TO_CAREERS.put("Social Connector", 
            new String[]{"Human Resources Manager", "Sales Representative", "Social Worker", "Customer Success Manager"});
        
        PERSONALITY_TO_CAREERS.put("Strategic Leader", 
            new String[]{"Project Manager", "Business Development Manager", "Management Consultant", "Operations Director"});
        
        PERSONALITY_TO_CAREERS.put("Detail-oriented Specialist", 
            new String[]{"Quality Assurance Engineer", "Accountant", "Database Administrator", "Compliance Officer"});
        
        PERSONALITY_TO_CAREERS.put("Balanced Generalist", 
            new String[]{"Business Analyst", "Product Manager", "Technical Writer", "Solutions Architect"});
    }
    
    public String predictCareer(Map<Long, Integer> userAnswers, String personalityType) {
        // In a real application, you would use a trained SMILE model
        // For now, implement a simple rule-based approach
        
        if (!PERSONALITY_TO_CAREERS.containsKey(personalityType)) {
            return "Business Analyst"; // Default career
        }
        
        String[] careers = PERSONALITY_TO_CAREERS.get(personalityType);
        
        // For demonstration, return the first career in the list
        // In a real app, you'd use additional features to select the most suitable career
        return careers[0];
    }
    
    // In a real application, you'd add methods to load the model and make predictions
    // using SMILE's RandomForest or other algorithms
}