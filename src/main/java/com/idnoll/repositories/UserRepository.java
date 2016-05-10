package com.idnoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idnoll.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
	
}
