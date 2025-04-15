package com.mypredictor.career_predictor.service;

import com.mypredictor.career_predictor.ml.CareerPredictor;
import com.mypredictor.career_predictor.ml.PersonalityPredictor;
import com.mypredictor.career_predictor.model.CareerOption;
import com.mypredictor.career_predictor.model.PersonalityType;
import com.mypredictor.career_predictor.model.UserResponse;
import com.mypredictor.career_predictor.repository.CareerOptionRepository;
import com.mypredictor.career_predictor.repository.PersonalityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PredictionService {
    private final PersonalityPredictor personalityPredictor;
    private final CareerPredictor careerPredictor;
    private final PersonalityTypeRepository personalityTypeRepository;
    private final CareerOptionRepository careerOptionRepository;

    @Autowired
    public PredictionService(
            PersonalityPredictor personalityPredictor,
            CareerPredictor careerPredictor,
            PersonalityTypeRepository personalityTypeRepository,
            CareerOptionRepository careerOptionRepository) {
        this.personalityPredictor = personalityPredictor;
        this.careerPredictor = careerPredictor;
        this.personalityTypeRepository = personalityTypeRepository;
        this.careerOptionRepository = careerOptionRepository;
    }

    public UserResponse processMCQResponses(Map<Long, Integer> userAnswers) {
        // Create user response object
        UserResponse userResponse = new UserResponse();
        userResponse.setAnswers(userAnswers);

        // Predict personality type
        String personalityTypeName = personalityPredictor.predictPersonalityType(userAnswers);
        PersonalityType personalityType = personalityTypeRepository.findByName(personalityTypeName);
        userResponse.setPredictedPersonalityType(personalityType);

        // Predict career option
        String careerName = careerPredictor.predictCareer(userAnswers, personalityTypeName);
        CareerOption careerOption = careerOptionRepository.findByName(careerName);
        userResponse.setPredictedCareerOption(careerOption);

        return userResponse;
    }
}