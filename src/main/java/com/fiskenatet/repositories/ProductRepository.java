package com.fiskenatet.repositories;

import com.fiskenatet.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by nordi_000 on 2016-04-20.
 */
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    public List<ProductModel> findProductsByCategory(String category);

    public List<ProductModel> findProductsByCategoryAndOwnerId(String category, Long ownerId);

    public List<ProductModel> findProductsByIsSold(String isSold);

    public List<ProductModel> findProductsByTitleContaining(String title);

    public List<ProductModel> findProductsByDescriptionContaining(String description);

    public List<ProductModel> findProductsByEndDateBefore(Date endDate);

}

