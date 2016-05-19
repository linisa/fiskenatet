package com.example.fiskenatet.repositories;

import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Marcin Retek on 2016-05-04.
 */
public interface HistoryRepository extends JpaRepository<HistoryModel, Long> {

    public List<HistoryModel> findHistoryByOwner(Long ownerId);

    public List<HistoryModel> findHistoryByBuyerUsername(String username);
}
