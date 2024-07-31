package com.example.inbound_backend.controller;

import com.example.inbound_backend.entity.Agent;
import com.example.inbound_backend.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AgentController {
    @Autowired
    private AgentService agentService;

//    @GetMapping("/agent/{id}")
//    public Agent findbyLicenceNo(@PathVariable String id){
//        return agentService.findByLicenceNo(id);
//    }

    @GetMapping("/agent")
    public ResponseEntity <List<Agent>> getAllStudent() {
        return agentService.findAllAgent();
    }






}
