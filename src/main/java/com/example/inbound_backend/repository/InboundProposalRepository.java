package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.InboundProposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InboundProposalRepository extends JpaRepository<InboundProposal ,String> {

    List<InboundProposal> findAllByAndPassportNoAndPassportIssuedCountry (String passportNo, String passportIssueCountry);
}
