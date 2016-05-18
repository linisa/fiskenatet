package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.controllers.HistoryController;
import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.HistoryRepository;
import com.example.fiskenatet.services.HistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by Linus on 2016-05-18.
 */
@RunWith(MockitoJUnitRunner.class)
public class HistoryControllerTest {

    @InjectMocks
    private HistoryController historyController;
    @Mock
    private HistoryService historyService;
    @Mock
    private HistoryRepository historyRepository;

    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 2L;
    private static final String TITLE_1 = "Torsk";
    private static final String TITLE_2 = "Blåval";
    private static final String CATEGORY_1 = "Fiskar";
    private static final String CATEGORY_2 = "Valar";
    private static final String DESCRIPTION_1 = "En torsk";
    private static final String DESCRIPTION_2 = "En val";

    private static final HistoryModel fish1 = new HistoryBuilder().id(ID_1).title(TITLE_1).category(CATEGORY_1).description(DESCRIPTION_1).build();
    private static final HistoryModel fish2 = new HistoryBuilder().id(ID_2).title(TITLE_2).category(CATEGORY_2).description(DESCRIPTION_2).build();

    @Test
    public void testCreateHistory(){
        historyController.createHistory(fish1);
        verify(historyService).saveHistory(fish1);
    }


}
