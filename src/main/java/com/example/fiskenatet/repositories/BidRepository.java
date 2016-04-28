package com.example.fiskenatet.repositories;

import com.example.fiskenatet.models.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nordi_000 on 2016-04-27.
 */
public interface BidRepository extends JpaRepository<BidModel, Long> {

    //public List<BidModel> findBidByProductId(Long productId);

   /*
    // hitta budet med valt id och retunera detta budets pris (amount) som en sträng

    @Query(value = "SELECT b.amount FROM BidModel b where b.id = :id", nativeQuery=true)
    String findAmountById(@Param("id") Long id);

    // hitta budet med valt id och retunera som bidmodel
    BidModel findById(Long id);

    // ska retunera en lista med alla bud som har product_id = det vi skickar in
    List<BidModel> findBidsByProductId(Long id);
    */

}
