package com.mypredictor.career_predictor.ml;

import org.springframework.stereotype.Component;
import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.type.DataTypes;
import smile.data.type.StructField;
import smile.data.type.StructType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonalityPredictor {
    
    private RandomForest model;
    private StructType schema;
    private String[] personalityTypes = {
        "Analytical Thinker", "Creative Innovator", "Social Connector", 
        "Strategic Leader", "Detail-oriented Specialist", "Balanced Generalist"
    };
    
    // Initialize the model in constructor or via @PostConstruct
    public PersonalityPredictor() {
        try {
            // Define the input schema for our model
            // In a real application, this would match your training data
            List<StructField> fields = new ArrayList<>();
            fields.add(new StructField("analytical", DataTypes.IntegerType));
            fields.add(new StructField("creative", DataTypes.IntegerType));
            fields.add(new StructField("social", DataTypes.IntegerType));
            fields.add(new StructField("leadership", DataTypes.IntegerType));
            fields.add(new StructField("detailOriented", DataTypes.IntegerType));
            fields.add(new StructField("personalityType", DataTypes.StringType));
            
            this.schema = new StructType(fields.toArray(new StructField[0]));
            
            // In a real application, you would load a pre-trained model here
            // For now, we'll just create a placeholder model
            // This would normally be replaced with actual model loading code:
            // this.model = smile.read(new File("path/to/model.model"));
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize personality predictor model", e);
        }
    }
    
    public String predictPersonalityType(Map<Long, Integer> userAnswers) {
        try {
            // Transform user answers into features the model can use
            double[] features = convertAnswersToFeatures(userAnswers);
            
            // In a real application with a trained model:
            // return personalityTypes[model.predict(features)];
            
            // For now, using a simple rule-based approach as placeholder
            return determinePersonalityTypeSimple(features);
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to predict personality type", e);
        }
    }
    
    private double[] convertAnswersToFeatures(Map<Long, Integer> userAnswers) {
        // Extract features from raw answers
        double[] features = new double[5]; // 5 personality dimensions
        
        // Example feature extraction (would be more sophisticated in reality)
        int analytical = 0, creative = 0, social = 0, leadership = 0, detailOriented = 0;
        int countAnalytical = 0, countCreative = 0, countSocial = 0, countLeadership = 0, countDetail = 0;
        
        // Calculate feature scores based on question categories and answer values
        for (Map.Entry<Long, Integer> entry : userAnswers.entrySet()) {
            Long questionId = entry.getKey();
            Integer value = entry.getValue();
            
            // In a real app, you'd look up the question category and calculate scores accordingly
            // This is simplified for demonstration
            if (questionId % 5 == 0) {
                analytical += value;
                countAnalytical++;
            } else if (questionId % 5 == 1) {
                creative += value;
                countCreative++;
            } else if (questionId % 5 == 2) {
                social += value;
                countSocial++;
            } else if (questionId % 5 == 3) {
                leadership += value;
                countLeadership++;
            } else {
                detailOriented += value;
                countDetail++;
            }
        }
        
        // Calculate average scores (avoiding division by zero)
        features[0] = countAnalytical > 0 ? analytical / (double) countAnalytical : 0;
        features[1] = countCreative > 0 ? creative / (double) countCreative : 0;
        features[2] = countSocial > 0 ? social / (double) countSocial : 0; 
        features[3] = countLeadership > 0 ? leadership / (double) countLeadership : 0;
        features[4] = countDetail > 0 ? detailOriented / (double) countDetail : 0;
        
        return features;
    }
    
    private String determinePersonalityTypeSimple(double[] features) {
        // Simple rule-based approach for demonstration purposes
        // In a real app, you'd use the ML model's prediction
        
        // Find the highest scoring category
        int maxIndex = 0;
        for (int i = 1; i < features.length; i++) {
            if (features[i] > features[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Check if there's a clear winner or if scores are balanced
        double maxScore = features[maxIndex];
        double avgScore = 0;
        for (double feature : features) {
            avgScore += feature;
        }
        avgScore /= features.length;
        
        // If the highest score isn't significantly higher than average, it's balanced
        if (maxScore - avgScore < 0.5) {
            return "Balanced Generalist";
        }
        
        // Map the highest category to a personality type
        switch (maxIndex) {
            case 0: return "Analytical Thinker";
            case 1: return "Creative Innovator";
            case 2: return "Social Connector";
            case 3: return "Strategic Leader";
            case 4: return "Detail-oriented Specialist";
            default: return "Balanced Generalist";
        }
    }
}
