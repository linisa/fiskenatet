package com.example.fiskenatet.testUsers;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private static TestUserDAL mockedTestUserDAL;
    private static TestUserModel user1;
    private static TestUserModel user2;

    @BeforeClass
    public static void setUp() throws Exception {

        mockedTestUserDAL = mock(TestUserDAL.class);

        user1 = new TestUserModel(1, "Trazan", "Bananahamsson", "bananaHammock", "pass");
        user2 = new TestUserModel(2, "Banane", "Szbrjnicch", "Onkel", "123");

        when(mockedTestUserDAL.getAllUsers()).thenReturn(Arrays.asList(user1, user2));
        when(mockedTestUserDAL.getUserModel(1)).thenReturn(user1);
        when(mockedTestUserDAL.getUserModel(2)).thenReturn(user2);
        when(mockedTestUserDAL.addUserModel(user2)).thenReturn(user2.getFirstName());
        when(mockedTestUserDAL.addUserModel(user1)).thenReturn(user1.getFirstName());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<TestUserModel> allUsers = mockedTestUserDAL.getAllUsers();
        assertEquals(2, allUsers.size());
        TestUserModel testUserModel = allUsers.get(0);
        assertEquals(1, testUserModel.getId());
        assertEquals("Trazan", testUserModel.getFirstName());
        assertEquals("Bananahamsson", testUserModel.getLastName());
        assertEquals("bananaHammock", testUserModel.getUserName());
        assertEquals("pass", testUserModel.getPassword());
    }

    @Test
    public void testGetUser() throws Exception{
        long id = 2;
        TestUserModel testUserModel = mockedTestUserDAL.getUserModel(id);
        assertNotNull(testUserModel);
        assertEquals("Banane", testUserModel.getFirstName());
        assertEquals("Szbrjnicch", testUserModel.getLastName());
        assertEquals("Onkel", testUserModel.getUserName());
        assertEquals("123", testUserModel.getPassword());

    }

    @Test
    public void testAddUser() throws Exception {
        String firstName = mockedTestUserDAL.addUserModel(user1);
        assertNotNull(firstName);
        assertEquals(user1.getFirstName(), firstName);
    }

}
