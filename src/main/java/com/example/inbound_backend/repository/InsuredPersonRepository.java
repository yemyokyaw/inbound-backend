package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.InsuredPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuredPersonRepository extends JpaRepository<InsuredPerson,String> {
}
