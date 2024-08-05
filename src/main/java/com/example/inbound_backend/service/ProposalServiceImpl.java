package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.ProposalDTO;
import com.example.inbound_backend.entity.InboundProposal;
import com.example.inbound_backend.repository.InboundProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProposalServiceImpl implements ProposalService{
    @Autowired
    private InboundProposalRepository inboundProposalRepository;

    @Override
    public List<ProposalDTO> findAllProposal(ProposalDTO propoDTO) throws Exception {
       List<InboundProposal> proposals = inboundProposalRepository.findAllByAndPassportNoAndPassportIssuedCountry(propoDTO.getPassportNo(),propoDTO.getPassportIssuedCountry());
       if (proposals == null) throw new Exception("Proposal not found");

       List<ProposalDTO> proposalDTOList = new ArrayList<>();
       for (InboundProposal p : proposals){
           ProposalDTO proposalDTO = new ProposalDTO();
           proposalDTO.setCertificateNo(p.getCertificateNo());
           proposalDTO.setName(p.getInsuredName());
           proposalDTO.setAge(p.getAge());
           proposalDTO.setPhoneNo(p.getPhoneNo());
           proposalDTO.setCoveragePlan(p.getCoveragePlan());
           proposalDTO.setPremiumRate(p.getPremiumRate());
           proposalDTO.setSubmittedDate(p.getSubmittedDate());
           proposalDTO.setPassportNo(p.getPassportNo());
           proposalDTOList.add(proposalDTO);
       }
       return proposalDTOList;
    }
}
