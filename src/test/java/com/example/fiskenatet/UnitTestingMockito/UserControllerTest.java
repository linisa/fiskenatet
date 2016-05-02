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

import static org.assertj.core.api.Assertions.*;
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

    private static final String USER_NAME = "Berra";
    private static final String FIRST_NAME = "Bert";
    private static final Long USER_ID = 1L;

    private static final UserModel user1 = new UserBuilder().id(USER_ID).firstName(FIRST_NAME).userName(USER_NAME).build();
    private static final UserModel user2 = new UserBuilder().id(2L).firstName("Kalle").userName("Acmilan").build();
    private static final UserModel user3 = new UserBuilder().build();

    @Test
    public void testFindAllUsers(){
        ArrayList<UserModel> listan = new ArrayList<UserModel>();
        listan.add(user1);
        listan.add(user2);
        ResponseEntity respons= new ResponseEntity<ArrayList<UserModel>>(listan, HttpStatus.OK);
        given(userService.getAllUsers()).willReturn(Arrays.asList(user1, user2));
        assertThat(userController.getAllUsers()).isEqualTo(respons);
    }

    @Test
    public void testUpdateUser() {
        userController.updateUser(2L, user1);
        verify(userService).updateUser(2L, user1);
    }

    @Test
    public void testGetUser(){
        given(userService.getUser(USER_ID)).willReturn(user1);
        ResponseEntity respons= new ResponseEntity<UserModel>(user1, HttpStatus.OK);
        assertThat(userController.getUser(USER_ID)).isEqualTo(respons);
    }
    @Test
    public void testDeleteUser() {
        userController.deleteUser(USER_ID);
        verify(userService).deleteUser(USER_ID);

    }
    @Test
    public void testAddUser(){
        userController.createUser(user1);
        verify(userService).saveUser(user1);
    }
    @Test
    public void testGetUserByUsername(){
        given(userService.getUserByUserName("Berra")).willReturn(user1);
        ResponseEntity respons= new ResponseEntity<UserModel>(user1, HttpStatus.OK);
        assertThat(userController.getUserByUserName("Berra")).isEqualTo(respons);
    }
}
