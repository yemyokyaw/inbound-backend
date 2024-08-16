package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.InboundProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InboundProposalRepository extends JpaRepository<InboundProposal ,String> {

    List<InboundProposal> findAllByPassportNoAndPassportIssuedCountry (String passportNo, String passportIssueCountry);

    @Query(value = "SELECT nextval(certificate_seq)", nativeQuery = true)
    Long getNextSequenceValue();

}
