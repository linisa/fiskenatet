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
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by nordi_000 on 2016-04-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    private static final String USER_NAME = "Berra";
    private static final String FIRST_NAME = "Bert";
    private static final Long USER_ID = 1L;

    /*
    private static final UserModel useMe = new UserBuilder().userName(USER_NAME).build();
    private static final UserModel newUser1 = new UserBuilder().build();
    private static final UserModel newUser2 = new UserBuilder().userName("Fittsmurf").firstName("Smurfan").build();
    */
    private static final UserModel user1 = new UserBuilder().id(USER_ID).firstName(FIRST_NAME).userName(USER_NAME).build();




    private ArgumentCaptor anyUser = ArgumentCaptor.forClass(UserModel.class);

    /*
    @Test
    public void findAllUsers(){
        given(userService.saveUser(newUser1)).(useMe);
        assertThat(userController.getUserByUserName(USER_NAME)).isEqualTo(useMe);
        //given(userRepository.saveAndFlush(newUser1)).willReturn(useMe);

    }
    */
    @Test
    public void deleteTest() {

        userController.deleteUser(USER_ID);
        verify(userService).deleteUser(USER_ID);

    }
}
