package org.example.userservice.application.services.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "user-created";

    public void sendUserCreatedMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
