package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.PremiumRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PremiumRateRepository extends JpaRepository<PremiumRate,String> {
    @Query("SELECT p FROM PremiumRate p WHERE p.days = :days AND p.fromAge <= :age AND p.toAge >= :age")
    PremiumRate findByDays(int days, int age);

}
