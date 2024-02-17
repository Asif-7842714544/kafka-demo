package com.example.kafka.Controller;

import com.example.kafka.Payload.Student;
import com.example.kafka.Producer.KafkaJsonProducer;
import com.example.kafka.Producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MsgController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

//    @PostMapping
//    public ResponseEntity<String> sendMessage(@RequestBody String msg) {
//        kafkaProducer.sendMessage(msg);
//        return ResponseEntity.ok("message queued successfully");
//    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("message queued successfully");
    }
}
