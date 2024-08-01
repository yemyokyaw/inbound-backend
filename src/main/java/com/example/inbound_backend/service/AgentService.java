package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.AgentDTO;

public interface AgentService {
     AgentDTO getAgentByLicence (AgentDTO agentDTO) throws Exception;

}
