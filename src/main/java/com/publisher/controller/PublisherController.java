package com.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.publisher.config.GCPConfig;

@RestController
public class PublisherController {

    @Autowired
    private GCPConfig.PubsubOutboundGateway messagingGateway;

    @GetMapping("/message/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable("message") String message) {
        messagingGateway.sendToPubsub(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
