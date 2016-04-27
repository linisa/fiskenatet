package com.example.fiskenatet.repositories;

import com.example.fiskenatet.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    public UserModel findUserByUserName(String userName);

}
