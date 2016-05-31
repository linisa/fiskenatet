package com.fiskenatet.testUsers;

import java.util.Collections;
import java.util.List;

public class TestUserDAL {

    private static TestUserDAL testUserDAL = new TestUserDAL();

    public List<TestUserModel> getAllUsers() {
        return Collections.emptyList();
    }

    public TestUserModel getUserModel(long id) {
        return null;
    }

    public String addUserModel(TestUserModel testUserModel) {
        return  testUserModel.getFirstName();
    }

    public static TestUserDAL getInstance() {
        return testUserDAL;
    }

}
