package com.example.fiskenatet.repositories;

import com.example.fiskenatet.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fiskenatet.models.ProductModel;

import java.util.List;

/**
 * Created by nordi_000 on 2016-04-20.
 */
public interface ProductRepository extends JpaRepository<ProductModel, Long> {


    public List<ProductModel> findProductsByCategory(String category);

}

