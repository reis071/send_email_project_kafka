package org.example.user_service_email.services.email;

import org.example.user_service_email.dtos.user.UserDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmailWelcome(UserDTO userDTO) {

        var message = new SimpleMailMessage();

        message.setFrom("noreply@microservices.com.br");
        message.setTo(userDTO.getEmail());
        message.setSubject("welcome!");
        message.setText(String.format("Hello %s, welcome to our platform!", userDTO.getName()));

        mailSender.send(message);
    }
}
