package com.example.fiskenatet.services;

import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin Retek on 2016-05-04.
 */
@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    // skapa produkt
    public void saveHistory(HistoryModel historyModel) {
        historyRepository.saveAndFlush(historyModel); // saveandflush betyder sparar och skickar upp till databasen(?) direkt
    }

    // hämta en alla produkter med en specifik ägare
    public List<HistoryModel> getHistoryByOwner(Long ownerId){
        return historyRepository.findHistoryByOwner(ownerId);
    }

}
