package com.Microservice.question_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Microservice.question_service.model.Question;
import com.Microservice.question_service.model.QuestionWrapper;
import com.Microservice.question_service.model.QuizResponse;



public interface QuestionService {

	List<Question> getAllQuestions();

	List<Question> getQuestionsByCategory(String name);

	String addQuestion(Question question);

	String updateQuestionByid(int id, Question question);

	String deletQuestionByid(int id);

	ResponseEntity<List<Integer>> getQuestionsForQuiz(String category);

	ResponseEntity<List<QuestionWrapper>> getQuestionById(List<Integer> id);

	ResponseEntity<Integer> getScoreForQuiz(List<QuizResponse> response);

	
}
