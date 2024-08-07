package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.ProposalDTO;
import com.example.inbound_backend.entity.*;
import com.example.inbound_backend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProposalServiceImpl implements ProposalService{

    private InboundProposalRepository inboundProposalRepository;
    private BeneficiaryRepository beneficiaryRepository;

    private ChildRepository childRepository;

    private InsuredPersonRepository insuredPersonRepository;
    private AgentRepository agentRepository;

    private CountryRepository countryRepository;

    public ProposalServiceImpl(InboundProposalRepository inboundProposalRepository, BeneficiaryRepository beneficiaryRepository, ChildRepository childRepository, InsuredPersonRepository insuredPersonRepository, CountryRepository countryRepository, AgentRepository agentRepository) {
        this.inboundProposalRepository = inboundProposalRepository;
        this.beneficiaryRepository = beneficiaryRepository;
        this.childRepository = childRepository;
        this.insuredPersonRepository = insuredPersonRepository;
        this.countryRepository = countryRepository;
        this.agentRepository = agentRepository;
    }

    @Override
    public List<ProposalDTO> findAllProposal(ProposalDTO propoDTO) throws Exception {
       List<InboundProposal> proposals = inboundProposalRepository.findAllByAndPassportNoAndPassportIssuedCountry(propoDTO.getPassportNo(),propoDTO.getPassportIssuedCountry());
       if (proposals == null) throw new Exception("Proposal not found");

       List<ProposalDTO> proposalDTOList = new ArrayList<>();
       for (InboundProposal p : proposals){
           ProposalDTO proposalDTO = new ProposalDTO();
           proposalDTO.setCertificateNo(p.getCertificateNo());
           proposalDTO.setInsuredPersonName(p.getInsuredName());
           proposalDTO.setAge(p.getAge());
           proposalDTO.setPhoneNo(p.getPhoneNo());
           proposalDTO.setCoveragePlan(p.getCoveragePlan());
           proposalDTO.setPremiumRate(p.getPremiumRate());
           proposalDTO.setSubmittedDate(p.getSubmittedDate());
           proposalDTO.setPassportNo(p.getPassportNo());
           proposalDTO.setInsuredPersondob(p.getInsuredPerson().getDob());
           proposalDTO.setPassportIssuedCountry(p.getPassportIssuedCountry());
           proposalDTO.setIsChild(p.getInsuredPerson().getIsChild());
           if (p.getAgent() != null){
               proposalDTO.setAgentName(p.getAgent().getName());
           }

           if(p.getChild() != null){
               proposalDTO.setChildName(p.getChild().getName());
               proposalDTO.setChildDob(p.getChild().getDob());
           }

           proposalDTO.setJourneyFrom(p.getJourneyfrom().getName());

           proposalDTOList.add(proposalDTO);

       }
       return proposalDTOList;
    }

    @Override
    @Transactional
    public void createProposal(ProposalDTO proposalDTO) {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setName(proposalDTO.getBeneficiaryName());
        beneficiary.setDob(proposalDTO.getBeneficiarydob());
        beneficiary.setNin(proposalDTO.getNin());
        beneficiary.setAddress(proposalDTO.getAddress());
        beneficiary.setPhoneNo(proposalDTO.getBeneficiaryPhNo());
        beneficiary.setRelationship(proposalDTO.getRelationship());
        beneficiary.setEmail(proposalDTO.getBeneficiaryEmail());

        Country c1 = countryRepository.findCountryByNameIgnoreCase(proposalDTO.getBenefiCountry());
        beneficiary.setResidentCountry(c1);

        beneficiaryRepository.save(beneficiary);

        InsuredPerson insuredPerson = new InsuredPerson();
        insuredPerson.setName(proposalDTO.getInsuredPersonName());
        insuredPerson.setDob(proposalDTO.getInsuredPersondob());
        insuredPerson.setGender(proposalDTO.getInsuredPersongender());
        insuredPerson.setLocalAddress(proposalDTO.getLocaladdress());
        insuredPerson.setForeignAddress(proposalDTO.getForeignAddress());
        insuredPerson.setEmail(proposalDTO.getInsuredPersonEmail());
        insuredPerson.setPhoneNo(proposalDTO.getPhoneNo());
        insuredPerson.setPassportNo(proposalDTO.getPassportNo());
        insuredPerson.setPassportIssuedDate(proposalDTO.getPassportIssuedDate());
        insuredPerson.setPassportNo(proposalDTO.getPassportNo());
        insuredPerson.setIsChild(proposalDTO.getIsChild());

        insuredPerson.setBeneficiary(beneficiary);
        Country country2 = countryRepository.findCountryByNameIgnoreCase(proposalDTO.getResidentCountry());
        insuredPerson.setResidentCountry(country2);

        Country c = countryRepository.findCountryByNameIgnoreCase(proposalDTO.getPassportCountry());
        insuredPerson.setPassportIssuedCountry(c);


        insuredPersonRepository.save(insuredPerson);


        //child

        Child child = null;
        if (proposalDTO.getIsChild()) {
            child = new Child();
            child.setName(proposalDTO.getChildName());
            child.setDob(proposalDTO.getChildDob());
            child.setGender(proposalDTO.getChildGender());
            child.setGurdianceName(proposalDTO.getGurdianceName());
            child.setRelationship(proposalDTO.getChildRelationship());

            child.setInsuredPerson(insuredPerson);

            childRepository.save(child);
        }

        InboundProposal inboundProposal = new InboundProposal();
        inboundProposal.setAge(proposalDTO.getAge());
        inboundProposal.setArrivalDate(proposalDTO.getArrivalDate());
        inboundProposal.setCertificateNo("Sample No");
        inboundProposal.setCoveragePlan(proposalDTO.getCoveragePlan());
        inboundProposal.setInsuredName(proposalDTO.getInsuredPersonName());
        inboundProposal.setPassportIssuedDate(proposalDTO.getPassportIssuedDate());
        inboundProposal.setPassportNo(proposalDTO.getPassportNo());
        inboundProposal.setPhoneNo(proposalDTO.getPhoneNo());
        inboundProposal.setPolicyStartDate(proposalDTO.getPolicyStartDate());
        inboundProposal.setPolicyEndDate(proposalDTO.getPolicyEndDate());
        inboundProposal.setPremiumRate(proposalDTO.getPremiumRate());
        inboundProposal.setServiceFees(proposalDTO.getServiceFees());
        inboundProposal.setSubmittedDate(proposalDTO.getSubmittedDate());
        inboundProposal.setPassportIssuedCountry(proposalDTO.getPassportCountry());


        Agent agent = agentRepository.findAgentByLicenceNo(proposalDTO.getLicenceNo());
        inboundProposal.setAgent(agent);

        inboundProposal.setBeneficiary(beneficiary);
        inboundProposal.setChild(child);
        inboundProposal.setInsuredPerson(insuredPerson);

        Country country = countryRepository.findCountryByNameIgnoreCase(proposalDTO.getJourneyFrom());
        inboundProposal.setJourneyfrom(country);

        inboundProposalRepository.save(inboundProposal);
    }



}
