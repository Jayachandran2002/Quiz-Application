package com.Microservice.quiz_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.quiz_service.model.QuestionWrapper;
import com.Microservice.quiz_service.model.QuizDto;
import com.Microservice.quiz_service.model.QuizResponse;
import com.Microservice.quiz_service.service.QuizServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizServiceImpl service;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto dto ) {
		
		return service.createQuiz(dto.getCategory(),dto.getTitle());
	}
	
	@GetMapping("get/{id}")
	public List<QuestionWrapper> getQuiz(@PathVariable int id) {
		return service.getQuizQuestionsById(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> postResponse(@PathVariable int id,@RequestBody List<QuizResponse> response){
		
		return service.postResponse(id,response);
	}
	
	

}
 