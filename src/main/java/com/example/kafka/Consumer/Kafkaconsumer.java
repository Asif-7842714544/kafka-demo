package com.example.kafka.Consumer;

import com.example.kafka.Payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Kafkaconsumer {

    @KafkaListener(topics = "asif",groupId = "myGroup")
    public void consumemsg(String message) {
        log.info(String.format("Consuming the message from asif topic :: %s", message));

    }

    @KafkaListener(topics = "asif",groupId = "myGroup")
    public void consumeJsonmsg(Student student) {
        log.info(String.format("Consuming the message from asif topic :: %s", student.toString()));

    }

}
