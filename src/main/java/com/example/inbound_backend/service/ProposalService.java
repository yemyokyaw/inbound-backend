package com.example.inbound_backend.service;



import com.example.inbound_backend.dto.ProposalDTO;

import java.util.List;

public interface ProposalService {
    List<ProposalDTO> findAllProposal (ProposalDTO proposalDTO) throws Exception;
}
