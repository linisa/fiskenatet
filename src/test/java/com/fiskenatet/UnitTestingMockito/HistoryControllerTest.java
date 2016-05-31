package com.fiskenatet.UnitTestingMockito;

import com.fiskenatet.controllers.HistoryController;
import com.fiskenatet.models.HistoryModel;
import com.fiskenatet.models.UserModel;
import com.fiskenatet.repositories.HistoryRepository;
import com.fiskenatet.services.HistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
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
    private static final Long OWNER_ID_1 = 1L;
    private static final String OWNER_USERNAME_1 = "p3lle1337";
    private static final UserModel OWNER_1 = new UserBuilder().id(OWNER_ID_1).userName(OWNER_USERNAME_1).build();
    private static final Long OWNER_ID_2 = 2L;
    private static final String OWNER_USERNAME_2 = "leifi";
    private static final UserModel OWNER_2 = new UserBuilder().id(OWNER_ID_2).userName(OWNER_USERNAME_2).build();

    private static final HistoryModel fish1 = new HistoryBuilder().id(ID_1).title(TITLE_1).category(CATEGORY_1).description(DESCRIPTION_1).owner(OWNER_1).build();
    private static final HistoryModel fish2 = new HistoryBuilder().id(ID_2).title(TITLE_2).category(CATEGORY_2).description(DESCRIPTION_2).owner(OWNER_2).build();


    @Test
    public void testGetHistoryByOwner(){
        ArrayList<HistoryModel> historyList = new ArrayList<HistoryModel>();
        historyList.add(fish1);
        ResponseEntity respons = new ResponseEntity<ArrayList<HistoryModel>>(historyList, HttpStatus.OK);
        given(historyService.getHistoryByOwner(OWNER_ID_1)).willReturn(Arrays.asList(fish1));
        assertThat(historyController.getHistoryByOwner(OWNER_ID_1)).isEqualTo(respons);
    }
    @Test
    public void testGetHistoryByUser(){
        ArrayList<HistoryModel> historyList = new ArrayList<HistoryModel>();
        historyList.add(fish2);
        ResponseEntity respons = new ResponseEntity<ArrayList<HistoryModel>>(historyList, HttpStatus.OK);
        given(historyService.getHistoryByBuyer(OWNER_USERNAME_2)).willReturn(Arrays.asList(fish2));
        assertThat(historyController.getHistoryByUser(OWNER_USERNAME_2)).isEqualTo(respons);
    }

}
