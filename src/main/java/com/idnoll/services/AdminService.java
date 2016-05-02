package com.idnoll.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.idnoll.models.QuestionModel;
import com.idnoll.repositories.QuestionRepository;

public class AdminService implements AdminServiceInterface {
	
	@Autowired
	QuestionRepository questionRepository; 
	
	@Override
	public QuestionModel createQuestion(QuestionModel questionModel) {
		return questionRepository.save(questionModel);
	}

	@Override
	public QuestionModel getQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionModel updateQuestion(QuestionModel questionModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionModel deleteQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}

}
