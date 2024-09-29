package com.Microservice.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Microservice.quiz_service.model.QuestionWrapper;
import com.Microservice.quiz_service.model.QuizResponse;


@FeignClient("QUESTION-SERVICE")
public interface FeignInterface {
	
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category);
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> id);
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScoreForQuiz(@RequestBody List<QuizResponse> response );

}
