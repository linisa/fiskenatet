package com.fiskenatet.testUserRating;

import com.fiskenatet.stuff.UserRating;
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
