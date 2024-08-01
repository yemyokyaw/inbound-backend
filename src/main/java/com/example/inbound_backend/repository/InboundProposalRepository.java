package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.InboundProposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboundProposalRepository extends JpaRepository<InboundProposal ,String> {
}
