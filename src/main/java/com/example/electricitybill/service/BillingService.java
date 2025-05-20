package com.example.electricitybill.service;

import com.example.electricitybill.model.Billing;
import com.example.electricitybill.model.Consumer;
import com.example.electricitybill.repository.BillingRepository;
import com.example.electricitybill.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private ConsumerRepository consumerRepository;

    public double calculateBill(int units) {
        double amount = 0;
        if (units <= 50) {
            amount = units * 3.5;
        } else if (units <= 150) {
            amount = (50 * 3.5) + ((units - 50) * 4.0);
        } else if (units <= 250) {
            amount = (50 * 3.5) + (100 * 4.0) + ((units - 150) * 5.2);
        } else {
            amount = (50 * 3.5) + (100 * 4.0) + (100 * 5.2) + ((units - 250) * 6.5);
        }
        return amount;
    }

    public Billing generateBill(Long consumerId, int units) {
        Consumer consumer = consumerRepository.findById(consumerId)
            .orElseThrow(() -> new RuntimeException("Consumer not found"));
        double amount = calculateBill(units);
        Billing bill = new Billing();
        bill.setConsumer(consumer);
        bill.setUnits(units);
        bill.setAmount(amount);
        bill.setBillingDate(LocalDate.now());
        return billingRepository.save(bill);
    }
}
