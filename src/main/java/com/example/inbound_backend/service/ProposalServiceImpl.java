package com.example.inbound_backend.service;

import com.example.inbound_backend.entity.InboundProposal;
import com.example.inbound_backend.repository.InboundProposalRepository;

import java.util.List;

public class ProposalServiceImpl implements ProposalService{

    private InboundProposalRepository inboundProposalRepository;

    @Override
    public List<InboundProposal> findAll() throws Exception {

    }
}
