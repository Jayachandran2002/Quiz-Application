package com.Microservice.quiz_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.quiz_service.model.Quiz;

public interface QuizRepo extends JpaRepository< Quiz, Integer> {

}