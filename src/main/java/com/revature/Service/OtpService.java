package com.revature.Service;


import ch.qos.logback.core.CoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class OtpService  {

    @Autowired
    private JavaMailSender mailSender;

    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOtpEmail(String to, String subject, String otp) {

        try
        {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("priyanka.ass09@gmail.com");
            message.setTo(to);
            message.setSubject("Please use this OTP to sign in and confirm your identity");
            message.setText("Your OTP is: " + otp + ". It is valid for 10 minutes.");
            System.out.println("  message  : "+message);
            mailSender.send(message);

            System.out.println("  Email sent successfully  : ");
        } catch(Exception e){
            System.out.println("Some exception error here" +e.getMessage());
            //e.printStackTrace();
        }
    }
}
