package com.example.inbound_backend.service;

import com.example.inbound_backend.repository.AgentRepository;
import com.example.inbound_backend.entity.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;

//    @Override
//    public Agent findByLicenceNo(String id) {
//     return findByLicenceNo(id);
//
//    }

    @Override
    public ResponseEntity<List<Agent>> findAllAgent() {
       return ResponseEntity.ok(agentRepository.findAll());
    }
}


