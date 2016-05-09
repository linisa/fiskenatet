package com.example.fiskenatet.testUserRating;

import com.example.fiskenatet.main.MailHandler;
import com.example.fiskenatet.main.UserRating;
import junit.framework.TestCase;

public class UserRatingTest extends TestCase{

    UserRating userRating;

    public void setUp () throws Exception {
        super.setUp();
        userRating = new UserRating();
    }

    public void testGetUserAverageRating() throws Exception{
        assertEquals("3", userRating.getUserAverageRating("4251"));
    }

}
