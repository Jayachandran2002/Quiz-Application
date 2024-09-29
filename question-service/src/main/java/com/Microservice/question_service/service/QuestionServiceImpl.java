package com.Microservice.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Microservice.question_service.model.Question;
import com.Microservice.question_service.model.QuestionWrapper;
import com.Microservice.question_service.model.QuizResponse;
import com.Microservice.question_service.repository.QuestionRepo;




@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo repo;

	@Override
	public List<Question> getAllQuestions() {
		return repo.findAll();
	}

	@Override
	public List<Question> getQuestionsByCategory(String name) {
		
		return repo.findAllByCategory(name);
	}

	@Override
	public String addQuestion(Question question) {
		if (question != null) {
			repo.save(question);
			return "Sucess(200 OK)";
		}else
			return "UnSucess";
	}

	@Override
	public String updateQuestionByid(int id, Question question) {
		Question orgQuestion = repo.findById(id).orElse(null);
		if(orgQuestion != null) {
			orgQuestion.setQuestionTitle(question.getQuestionTitle());
			orgQuestion.setLevel(question.getLevel());
			orgQuestion.setCategory(question.getCategory());
			orgQuestion.setOption1(question.getOption1());
			orgQuestion.setOption2(question.getOption2());
			orgQuestion.setOption3(question.getOption3());
			orgQuestion.setOption4(question.getOption4());
			orgQuestion.setRightAnswer(question.getRightAnswer());
			repo.save(orgQuestion);
			return "Sucess(200 OK)";
			}else
				return "UnSucess";
	}

	@Override
	public String deletQuestionByid(int id) {
		Question orgQuestion = repo.findById(id).orElse(null);
		if(orgQuestion != null) {
			repo.deleteById(id);
			return "Sucess(200 OK)";
		}else
			return "UnSucess";
	}

	@Override
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category) {
		List<Integer> questions = repo.findIdByCategory(category);
		
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuestionById(List<Integer> id) {
		List<QuestionWrapper> questionWrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		for(Integer qid : id) {
			questions.add(repo.findById(qid).get());
		}
		for(Question q : questions) {
			QuestionWrapper questionWrapper = new QuestionWrapper(q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getLevel(),q.getCategory());
			questionWrappers.add(questionWrapper);
		}
		return ResponseEntity.ok(questionWrappers);
	}

	@Override
	public ResponseEntity<Integer> getScoreForQuiz(List<QuizResponse> response) {
		int right =0;
		for(QuizResponse response2 : response) {
			Question question = repo.findById(response2.getId()).get();
			if (response2.getResponse().equals(question.getRightAnswer())) 
				right++;
		}
		return ResponseEntity.ok(right);
	}
	



}