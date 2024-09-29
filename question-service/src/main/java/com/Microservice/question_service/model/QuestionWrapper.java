package com.Microservice.question_service.model;

import lombok.Data;

@Data
public class QuestionWrapper {
	
	public QuestionWrapper(String questionTitle, String option1, String option2, String option3, String option4,
			String level, String category) {
		super();
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.level = level;
		this.category = category;
	}
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String level;
	private String category;
}
