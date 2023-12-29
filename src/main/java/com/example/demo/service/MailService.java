package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;
@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    JavaMailSenderImpl mailSender;

    public String sendEmail(String to,String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("pjoshiglobal@gmail.com");
        message.setReplyTo("pjoshiglobal@gmail.com");
        mailSender.send(message);
        return "done";
    }


}
