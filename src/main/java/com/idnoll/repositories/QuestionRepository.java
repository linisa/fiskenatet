package com.idnoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idnoll.models.QuestionModel;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long>{

}
