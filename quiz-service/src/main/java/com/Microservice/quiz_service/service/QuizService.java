package com.Microservice.quiz_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Microservice.quiz_service.model.QuestionWrapper;
import com.Microservice.quiz_service.model.QuizResponse;



public interface QuizService {

	ResponseEntity<String> createQuiz(String category, String title);

	List<QuestionWrapper> getQuizQuestionsById(int id);

	ResponseEntity<Integer> postResponse(int id, List<QuizResponse> response);

}
