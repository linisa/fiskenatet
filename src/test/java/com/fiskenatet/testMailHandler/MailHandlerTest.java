package com.fiskenatet.testMailHandler;

import com.fiskenatet.stuff.MailHandler;
import junit.framework.TestCase;

/**
 * Created by Linus on 2016-05-20.
 */
public class MailHandlerTest extends TestCase {

    private MailHandler mailHandler;

    public void setUp() throws Exception {
        super.setUp();
        mailHandler = new MailHandler();

    }
    public void testControlUserMail() throws Exception{
        assertTrue(mailHandler.controlUserMail("fiskenaetet@gmail.com"));
    }

}
