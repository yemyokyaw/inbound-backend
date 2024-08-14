package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.ProposalDTO;
import com.example.inbound_backend.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface ProposalService {
    List<ProposalDTO> findAllProposal (ProposalDTO proposalDTO) throws Exception;

    ResponseDTO createProposal (@ModelAttribute ProposalDTO proposalDTO) throws Exception;
}
