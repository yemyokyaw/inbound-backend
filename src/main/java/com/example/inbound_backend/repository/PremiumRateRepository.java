package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.PremiumRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumRateRepository extends JpaRepository<PremiumRate,String> {
    PremiumRate findByDays(int days);
}
