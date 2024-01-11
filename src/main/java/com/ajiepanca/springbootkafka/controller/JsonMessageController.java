package com.ajiepanca.springbootkafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajiepanca.springbootkafka.kafka.JsonKafkaProducer;
import com.ajiepanca.springbootkafka.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private JsonKafkaProducer kafkaProducer;
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);

	
	private JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
	
				
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message sent to kafka topic");
	}
	
}
