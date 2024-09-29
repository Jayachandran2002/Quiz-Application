
package com.Microservice.quiz_service.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	private String level;
	private String category;
}
