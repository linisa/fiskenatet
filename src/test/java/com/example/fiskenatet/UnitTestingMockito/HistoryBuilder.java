package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.UserModel;

/**
 * Created by Linus on 2016-05-18.
 */
public class HistoryBuilder {

    private HistoryModel historyModel = new HistoryModel();

    public HistoryBuilder id (Long id){
        historyModel.setId(id);
        return this;
    }
    public HistoryBuilder title(String title){
        historyModel.setTitle(title);
        return this;
    }
    public HistoryBuilder description (String description){
        historyModel.setDescription(description);
        return this;
    }
    public HistoryBuilder category (String category){
        historyModel.setCategory(category);
        return this;
    }

    public HistoryModel build(){
        return historyModel;
    }
}
