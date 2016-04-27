package com.example.fiskenatet.repositories;

import com.example.fiskenatet.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Erik on 2016-04-27.
 */
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
