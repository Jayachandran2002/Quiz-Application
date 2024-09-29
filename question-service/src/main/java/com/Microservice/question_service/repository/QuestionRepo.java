package com.Microservice.question_service.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Microservice.question_service.model.Question;



@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	List<Question> findAllByCategory(String name);
	
	
	@Query("SELECT q.id FROM Question q WHERE q.category = :category")
	List<Integer> findIdByCategory(@Param("category") String category);



}
