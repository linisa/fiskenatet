package com.idnoll.services;

import com.idnoll.models.QuestionModel;

public interface AdminServiceInterface {
	
	public QuestionModel createQuestion(QuestionModel questionModel);
	public QuestionModel getQuestion(String question);
	public QuestionModel updateQuestion(QuestionModel questionModel);
	public QuestionModel deleteQuestion(String question);
	
}
