package com.fiskenatet.repositories;

import com.fiskenatet.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    public UserModel findUserByUserName(String userName);

}
