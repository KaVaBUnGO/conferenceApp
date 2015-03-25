package com.conference.service;

import com.conference.ConferenceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendMail() {
        emailService.sendMail("kavabungo1@gmail.com", "Hello", "test message");
    }
}

