package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, String> {
}
