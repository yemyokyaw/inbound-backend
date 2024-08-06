package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.AgentDTO;
import com.example.inbound_backend.entity.Agent;
import com.example.inbound_backend.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;

    @Override
    public AgentDTO getAgentByLicence(AgentDTO agentDTO) throws Exception {
        Agent agent = agentRepository.findAgentByLicenceNo(agentDTO.getLicenceNo());

        if(agent == null) throw  new Exception("Agent not found");

        if(!agent.getPassword().equals(agentDTO.getPassword())) throw new Exception("Password incorrect");

        AgentDTO aDTO = new AgentDTO();
        aDTO.setLicenceNo(agent.getLicenceNo());
        aDTO.setName(agent.getName());

        return aDTO;
    }

}


