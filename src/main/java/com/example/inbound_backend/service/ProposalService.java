package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.ProposalDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface ProposalService {
    List<ProposalDTO> findAllProposal (ProposalDTO proposalDTO) throws Exception;

    void createProposal (@ModelAttribute ProposalDTO proposalDTO);
}
