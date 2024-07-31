package com.example.inbound_backend.service;

import com.example.inbound_backend.entity.Agent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AgentService {
//    Agent findAgentByLicenceNo(String licenceNo );
//    Agent findByLicenceNo(String id);
    ResponseEntity<List<Agent>> findAllAgent();
}
