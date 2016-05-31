package com.fiskenatet.UnitTestingMockito;

import com.fiskenatet.controllers.UserController;
import com.fiskenatet.models.UserModel;
import com.fiskenatet.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by nordi_000 on 2016-04-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    private static final String USER_NAME_1 = "Berra";
    private static final String FIRST_NAME_1 = "Bert";
    private static final Long USER_ID_1 = 1L;
    private static final String USER_NAME_2 = "Acmilan";
    private static final String FIRST_NAME_2 = "Kalle";
    private static final Long USER_ID_2 = 2L;
    private static final Long USER_ID_3 = 3L;
    private static final String BUYER_RATING_1 = "534";
    private static final String SELLER_RATING_1 = "3214";

    private static final UserModel user1 = new UserBuilder().id(USER_ID_1).firstName(FIRST_NAME_1).userName(USER_NAME_1).sellerRating(SELLER_RATING_1).buyerRating(BUYER_RATING_1).build();
    private static final UserModel user2 = new UserBuilder().id(USER_ID_2).firstName(FIRST_NAME_2).userName(USER_NAME_2).build();
    private static final UserModel user3 = new UserBuilder().id(USER_ID_3).firstName("Kalle").lastName("Anka").userName("kalleanka").email("kalle@anka.com").mobileNumber("12345").build();

    @Test
    public void testGetAllUsers(){
        ArrayList<UserModel> userList = new ArrayList<UserModel>();
        userList.add(user1);
        userList.add(user2);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<UserModel>>(userList, HttpStatus.OK);
        given(userService.findAllUsers()).willReturn(Arrays.asList(user1, user2));
        assertThat(userController.getAllUsers()).isEqualTo(responsMessage);
    }

    @Test
    public void testGetUser(){
        given(userService.findUser(USER_ID_1)).willReturn(user1);
        ResponseEntity responsMessage = new ResponseEntity<UserModel>(user1, HttpStatus.OK);
        assertThat(userController.getUser(USER_ID_1)).isEqualTo(responsMessage);
    }
    @Test
    public void testDeleteUser() {
        userController.deleteUser(USER_ID_1);
        verify(userService).deleteUserInDatabase(USER_ID_1);
    }
    @Test
    public void testGetUserByUsername(){
        given(userService.findUserByUserName(USER_NAME_1)).willReturn(user1);
        ResponseEntity responsMessage = new ResponseEntity<UserModel>(user1, HttpStatus.OK);
        assertThat(userController.getUserByUserName(USER_NAME_1)).isEqualTo(responsMessage);
    }
    @Test
    public void testCreateUser(){
        String response = "OK";
        given(userService.validateUserInputWhenCreating(user3)).willReturn(response);
        assertThat(userController.createUser(user3)).isEqualTo(response);
    }
    @Test
    public void testUpdateUser(){
        String response = "OK";
        given(userService.validateUserInputWhenUpdating(USER_ID_3, user3)).willReturn(response);
        assertThat(userController.updateUser(USER_ID_3, user3)).isEqualTo(response);
    }
    @Test
    public void testRateABuyer(){
        userController.rateABuyer(USER_ID_3, "3");
        verify(userService).saveBuyerRating(USER_ID_3, "3");
    }
    @Test
    public void testRateASeller(){
        userController.rateASeller(USER_ID_1, "1");
        verify(userService).saveSellerRating(USER_ID_1, "1");
    }
    @Test
    public void testGetBuyerRate(){
        String buyerRating = "534";
        given(userService.findBuyerRating(USER_ID_1)).willReturn(buyerRating);
        assertThat(userController.getBuyerRate(USER_ID_1)).isEqualTo(buyerRating);
    }
    @Test
    public void testGetSellerRate(){
        String sellerRating = "3214";
        given(userService.findSellerRating(USER_ID_1)).willReturn(sellerRating);
        assertThat(userController.getSellerRate(USER_ID_1)).isEqualTo(sellerRating);
    }
}
