package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.controllers.UserController;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.UserRepository;
import com.example.fiskenatet.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.asm.Type;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
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

    private static final UserModel user1 = new UserBuilder().id(USER_ID_1).firstName(FIRST_NAME_1).userName(USER_NAME_1).build();
    private static final UserModel user2 = new UserBuilder().id(USER_ID_2).firstName(FIRST_NAME_2).userName(USER_NAME_2).build();

    @Test
    public void testFindAllUsers(){
        ArrayList<UserModel> userList = new ArrayList<UserModel>();
        userList.add(user1);
        userList.add(user2);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<UserModel>>(userList, HttpStatus.OK);
        given(userService.findAllUsers()).willReturn(Arrays.asList(user1, user2));
        assertThat(userController.getAllUsers()).isEqualTo(responsMessage);
    }

    @Test
    public void testUpdateUser() {
        userController.updateUser(USER_ID_2, user1);
        verify(userService).updateUserInDatabase(USER_ID_2, user1);
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
    public void testAddUser(){
        userController.createUser(user1);
        verify(userService).saveUser(user1);
    }
    @Test
    public void testGetUserByUsername(){
        given(userService.findUserByUserName(USER_NAME_1)).willReturn(user1);
        ResponseEntity responsMessage = new ResponseEntity<UserModel>(user1, HttpStatus.OK);
        assertThat(userController.getUserByUserName(USER_NAME_1)).isEqualTo(responsMessage);
    }
}
