package com.example.fiskenatet.controllers;

import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.services.HistoryService;
import com.example.fiskenatet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Marcin Retek on 2016-05-04.
 */
@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;


    /*
    @CrossOrigin
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public void createHistory(@RequestBody HistoryModel historyModel) {
        productService.moveConfirmedProductToHistory(historyModel);
    }
    */

    @CrossOrigin
    @RequestMapping(value = "/history/{ownerId}", method = RequestMethod.GET)
    public ResponseEntity<List<HistoryModel>> getHistoryByOwner(@PathVariable Long ownerId) {
        return new ResponseEntity<List<HistoryModel>>(historyService.getHistoryByOwner(ownerId), HttpStatus.OK);

    }


}
