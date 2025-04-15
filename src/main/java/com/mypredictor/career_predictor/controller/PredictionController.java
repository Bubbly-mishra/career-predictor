package com.mypredictor.career_predictor.controller;

import com.mypredictor.career_predictor.model.UserResponse;
import com.mypredictor.career_predictor.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/predict")

public class PredictionController {
    private final PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping
    public UserResponse predictPersonalityAndCareer(@RequestBody Map<Long, Integer> userAnswers) {
        return predictionService.processMCQResponses(userAnswers);
    }
}