package com.example.electricitybill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.electricitybill.model.Billing;
import com.example.electricitybill.repository.BillingRepository;
import com.example.electricitybill.service.BillingService;

@RestController
@RequestMapping("/api/bills")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @Autowired
    private BillingRepository billingRepository;

    // Endpoint to generate a bill
    @PostMapping("/generate")
    public Billing generateBill(@RequestParam Long consumerId, @RequestParam int units) {
        return billingService.generateBill(consumerId, units);
    }

    // Endpoint to get all bills for a specific consumer
    @GetMapping("/consumer/{consumerId}")
    public List<Billing> getBillsForConsumer(@PathVariable Long consumerId) {
        return billingRepository.findByConsumerId(consumerId);
    }
}
