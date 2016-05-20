package com.example.fiskenatet.testMailHandler;

import com.example.fiskenatet.main.MailHandler;
import junit.framework.TestCase;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by Linus on 2016-05-20.
 */
public class MailHandlerTest extends TestCase {

    MailHandler mailHandler;

    public void setUp() throws Exception {
        super.setUp();
        mailHandler = new MailHandler();

    }

    public void testControlUserMail() throws Exception{
        assertTrue(mailHandler.controlUserMail("linisa89@hotmail.com"));
    }
    
}
