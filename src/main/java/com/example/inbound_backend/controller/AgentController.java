package com.example.inbound_backend.controller;

import com.example.inbound_backend.dto.AgentDTO;
import com.example.inbound_backend.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping("/agent")
   public ResponseEntity<?> findAgentByLicenceNo (@ModelAttribute AgentDTO agentDTO) throws Exception {
        return ResponseEntity.ok(agentService.getAgentByLicence(agentDTO));
    }


}
