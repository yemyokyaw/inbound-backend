package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository <Agent, String>{

}
