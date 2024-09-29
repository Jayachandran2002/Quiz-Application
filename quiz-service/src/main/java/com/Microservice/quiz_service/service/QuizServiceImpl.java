package com.Microservice.quiz_service.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Microservice.quiz_service.feign.FeignInterface;
import com.Microservice.quiz_service.model.Question;
import com.Microservice.quiz_service.model.QuestionWrapper;
import com.Microservice.quiz_service.model.Quiz;
import com.Microservice.quiz_service.model.QuizResponse;
import com.Microservice.quiz_service.repository.QuizRepo;


@Service
public class QuizServiceImpl implements QuizService  {
	
	@Autowired
	private QuizRepo repo;
	@Autowired
	private FeignInterface feignInterface;

	@Override
	public ResponseEntity<String> createQuiz(String category, String title) {
		List<Integer> questionIds = feignInterface.getQuestionsForQuiz(category).getBody();  
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionsIds(questionIds); 
		repo.save(quiz);
		return ResponseEntity.ok("Success");
	}
 
	@Override
	public List<QuestionWrapper> getQuizQuestionsById(int id) {
		Quiz quiz = repo.findById(id).get();
		List<Integer> QuestionId  = quiz.getQuestionsIds();
		List<QuestionWrapper> questions = feignInterface.getQuestionById(QuestionId).getBody();

		return questions;
	}

	@Override
	public ResponseEntity<Integer> postResponse(int id, List<QuizResponse> response) {
		 ResponseEntity<Integer> score = feignInterface.getScoreForQuiz(response);
		 return score;
	}
	

}
