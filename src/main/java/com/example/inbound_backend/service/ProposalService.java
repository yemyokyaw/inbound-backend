package com.example.inbound_backend.service;

import com.example.inbound_backend.entity.InboundProposal;

import java.util.List;

public interface ProposalService {
    List<InboundProposal> findAll() throws Exception;
}
