package org.example.user_service_email.services.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.user_service_email.dtos.user.UserDTO;
import org.example.user_service_email.services.email.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final EmailService emailService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user-created", groupId = "email-service-group")
    public void listen(String message) {
        try {
            UserDTO userDTORequest = objectMapper.readValue(message, UserDTO.class);

            emailService.sendEmailWelcome(userDTORequest);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
