package com.conference.service;

import com.conference.ConferenceApplication;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.Message;
import javax.mail.MessagingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    /*
        @Autowired
        private JavaMailSenderImpl javaMailSender;

        private GreenMail testSmtp;

        @Before
        public void testSmtpInit() {
            testSmtp = new GreenMail(ServerSetupTest.SMTP);
            testSmtp.start();

            javaMailSender.setPort(3025);
            javaMailSender.setHost("localhost");
        }
    */
    @Test
    public void testSendMail() {
        /*
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("test@sender.com");
        message.setTo("test@receiver.com");
        message.setSubject("test subject");
        message.setText("test message");
        javaMailSender.send(message);

        assertTrue(testSmtp.waitForIncomingEmail(5000, 1));
        Message[] messages = testSmtp.getReceivedMessages();
        assertEquals(1, messages.length);
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        assertEquals("test message", body); */

        emailService.sendMail("kavabungo1@gmail.com", "test", "test");

    }
/*
    @After
    public void cleanup() {
        testSmtp.stop();
    }
    */
}

