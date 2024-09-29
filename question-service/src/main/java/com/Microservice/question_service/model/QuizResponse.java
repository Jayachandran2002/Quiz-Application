package com.Microservice.question_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuizResponse {
	int id;
	String response;

}
