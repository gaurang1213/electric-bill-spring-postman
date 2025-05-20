package com.example.electricitybill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.electricitybill.model.Consumer;
import com.example.electricitybill.repository.ConsumerRepository;

@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerRepository consumerRepository;

    @PostMapping
    public Consumer createConsumer(@RequestBody Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    @GetMapping("/{id}")
    public Consumer getConsumer(@PathVariable Long id) {
        return consumerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Consumer not found"));
    }
}
