package com.mypredictor.career_predictor.service;

import com.mypredictor.career_predictor.model.Question;
import com.mypredictor.career_predictor.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    
    private final QuestionRepository questionRepository;
    
    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }
    
    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }
}