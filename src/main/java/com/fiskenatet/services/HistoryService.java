package com.fiskenatet.services;

import Application;
import com.fiskenatet.models.HistoryModel;
import com.fiskenatet.repositories.HistoryRepository;
import com.fiskenatet.repositories.ProductRepository;
import com.fiskenatet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Marcin Retek on 2016-05-04.
 */
@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired

    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    Logger log = Logger.getLogger(Application.class.getName());

    // hämta en alla produkter med en specifik ägare
    public List<HistoryModel> getHistoryByOwner(Long ownerId){
        List<HistoryModel> historyList = historyRepository.findHistoryByOwner(ownerId);
        log.info("Called method 'getHistoryByOwner' that returned a list of " + historyList.size() + " products from history for owner with ID: " + ownerId);
        return historyList;
    }
    public List<HistoryModel> getHistoryByBuyer(String username){
        List<HistoryModel> historyList = historyRepository.findHistoryByBuyerUsername(username);
        log.info("Called method 'getHistoryByBuyer' that returned a list of " + historyList.size() + " products from history for owner with username: " + username);
        return historyList;
    }


}
