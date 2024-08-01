package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, String> {
}
