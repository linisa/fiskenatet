package com.idnoll.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idnoll.models.QuestionModel;
import com.idnoll.repositories.QuestionRepository;

@Service
public class AdminService implements AdminServiceInterface {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public QuestionModel createQuestion(QuestionModel questionModel) {
		return questionRepository.save(questionModel);
	}

	@Override
	public QuestionModel getQuestion(Long id) {
		return questionRepository.findOne(id);
	}

	@Override
	public void updateQuestion(Long id, QuestionModel questionModel) {
		QuestionModel questionToUpdate = questionRepository.getOne(id);
		questionToUpdate.setQuestion(questionModel.getQuestion());
		questionToUpdate.setCorrectAnswer(questionModel.getCorrectAnswer());
		questionToUpdate.setFirstWrongAnswer(questionModel.getFirstWrongAnswer());
		questionToUpdate.setSecondWrongAnswer(questionModel.getSecondWrongAnswer());
		questionToUpdate.setCategory(questionModel.getCategory());
		questionToUpdate.setSubCategory(questionModel.getSubCategory());
		questionRepository.saveAndFlush(questionToUpdate);
	}

	@Override
	public QuestionModel deleteQuestion(Long id) {
		QuestionModel questionModel = getQuestion(id);
		questionRepository.delete(id);
		return questionModel;
	}

	@Override
	public List<QuestionModel> getAllQuestions() {
		return questionRepository.findAll();
	}

	

}
