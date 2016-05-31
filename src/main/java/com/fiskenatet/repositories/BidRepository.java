package com.fiskenatet.repositories;

import com.fiskenatet.models.BidModel;
import com.fiskenatet.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nordi_000 on 2016-04-27.
 */
public interface BidRepository extends JpaRepository<BidModel, Long> {

    public List<BidModel> findBidsByCurrentProduct(ProductModel product);

}
