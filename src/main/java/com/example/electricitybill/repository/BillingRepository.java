package com.example.electricitybill.repository;

import com.example.electricitybill.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByConsumerId(Long consumerId);
}
