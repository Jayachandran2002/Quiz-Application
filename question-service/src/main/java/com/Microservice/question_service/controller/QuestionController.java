package com.Microservice.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.question_service.model.Question;
import com.Microservice.question_service.model.QuestionWrapper;
import com.Microservice.question_service.model.QuizResponse;
import com.Microservice.question_service.service.QuestionService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	@GetMapping("allQuestions")
	public List<Question> getAllQuestion() {
		return service.getAllQuestions();
	}
	
	@GetMapping("category/{name}")
	public List<Question> getQuestionsByCategory(@PathVariable String name) {
		return service.getQuestionsByCategory(name);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question) {
		return service.addQuestion(question);
	}
	
	@PutMapping("update/{id}")
	public String updateQuestion(@PathVariable int id, @RequestBody Question question) {
		return service.updateQuestionByid(id,question);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable int id) {
		return service.deletQuestionByid(id);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category) {
		return service.getQuestionsForQuiz(category);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> id) {
		return service.getQuestionById(id);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScoreForQuiz(@RequestBody List<QuizResponse> response ){
		return service.getScoreForQuiz(response);
	}
	
	

}
 