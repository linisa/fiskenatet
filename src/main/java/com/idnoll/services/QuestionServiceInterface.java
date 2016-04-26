package com.idnoll.services;

import java.util.List;

import com.idnoll.models.QuestionModel;

public interface QuestionServiceInterface {

	public List<QuestionModel> listAll()throws Exception;
	public QuestionModel findById(Long id) throws Exception;
}
