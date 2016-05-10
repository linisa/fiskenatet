package com.idnoll.services;

import java.util.List;

import com.idnoll.models.QuestionModel;

public interface AdminServiceInterface {
	
	public QuestionModel createQuestion(QuestionModel questionModel);
	public QuestionModel getQuestion(Long id);
	public void updateQuestion(Long id, QuestionModel questionModel);
	public QuestionModel deleteQuestion(Long id);
	public List<QuestionModel> getAllQuestions();
	
}
