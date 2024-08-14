package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.ProposalDTO;
import com.example.inbound_backend.dto.ResponseDTO;
import com.example.inbound_backend.entity.*;
import com.example.inbound_backend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
       List<InboundProposal> proposals = inboundProposalRepository.findAllByPassportNoAndPassportIssuedCountry(propoDTO.getPassportNo(),propoDTO.getPassportIssuedCountry());
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
           proposalDTO.setInsuredPersondob(p.getInsuredPerson().getInsuredDob());
           proposalDTO.setPassportIssuedCountry(p.getPassportIssuedCountry());
           proposalDTO.setIsChild(p.getInsuredPerson().getIsChild());
           if (p.getAgent() != null){
               proposalDTO.setAgentName(p.getAgent().getAgentName());
           }

           if(p.getChild() != null){
               proposalDTO.setChildName(p.getChild().getChildName());
               proposalDTO.setChildDob(p.getChild().getChildDob());
           }

           proposalDTO.setJourneyFrom(p.getJourneyfrom().getCountryName());

           proposalDTOList.add(proposalDTO);

       }
       return proposalDTOList;
    }

    @Override
    @Transactional
    public ResponseDTO createProposal(ProposalDTO proposalDTO) {
        ResponseDTO res = new ResponseDTO();

        Beneficiary beneficiary = new Beneficiary();
        if(proposalDTO.getBeneficiaryName() == null) {
            res.setMessage("Beneficiary Name is required");
            res.setStatus("400");
            return res;
        }
        beneficiary.setBeneficiaryName(proposalDTO.getBeneficiaryName());

        if(proposalDTO.getBeneficiarydob() == null) {
            res.setMessage("Beneficiary Dob is required");
            res.setStatus("400");
            return res;
        }
        beneficiary.setBeneficiaryDob(proposalDTO.getBeneficiarydob());

        beneficiary.setNin(proposalDTO.getNin());

        if(proposalDTO.getAddress() == null) {
            res.setMessage("Beneficiary Address is required");
            res.setStatus("400");
            return res;
        }
        beneficiary.setBeneficiaryAddress(proposalDTO.getAddress());

        if(proposalDTO.getBeneficiaryPhNo() == null) {
            res.setMessage("Beneficiary Phone Number is required");
            res.setStatus("400");
            return res;
        }
        beneficiary.setBeneficiaryPhoneNo(proposalDTO.getBeneficiaryPhNo());

        if(proposalDTO.getRelationship() == null) {
            res.setMessage("Beneficiary relationship is required");
            res.setStatus("400");
            return res;
        }
        beneficiary.setBeneficiaryRelationship(proposalDTO.getRelationship());

        beneficiary.setBeneficiaryEmail(proposalDTO.getBeneficiaryEmail());

        Country c1 = countryRepository.findCountryByCountryNameIgnoreCase(proposalDTO.getBenefiCountry());
        if(proposalDTO.getBenefiCountry() == null) {
            res.setMessage("Beneficiary Resident country is required");
            res.setStatus("400");
            return res;
        }
        beneficiary.setResidentCountry(c1);

        beneficiaryRepository.save(beneficiary);

        //insured person
        InsuredPerson insuredPerson = new InsuredPerson();
        if(proposalDTO.getInsuredPersonName() == null) {
            res.setMessage("Insured Person Name is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setInsuredName(proposalDTO.getInsuredPersonName());

        if(proposalDTO.getInsuredPersondob() == null) {
            res.setMessage("Insured Person dob is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setInsuredDob(proposalDTO.getInsuredPersondob());

        if(proposalDTO.getInsuredPersongender() == null) {
            res.setMessage("Insured Person Gender is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setInsuredGender(proposalDTO.getInsuredPersongender());

        insuredPerson.setLocalAddress(proposalDTO.getLocaladdress());

        if(proposalDTO.getForeignAddress() == null) {
            res.setMessage("Insured Person foreign address is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setForeignAddress(proposalDTO.getForeignAddress());

        insuredPerson.setInsuredEmail(proposalDTO.getInsuredPersonEmail());

        if(proposalDTO.getPhoneNo() == null) {
            res.setMessage("Insured Person Phone Number is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setInsuredPhoneNo(proposalDTO.getPhoneNo());

        if(proposalDTO.getPassportNo() == null) {
            res.setMessage("Insured Person Passport is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setPassportNo(proposalDTO.getPassportNo());

        if(proposalDTO.getPassportIssuedDate() == null) {
            res.setMessage("Insured Person Passport Issued Date is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setPassportIssuedDate(proposalDTO.getPassportIssuedDate());

        if(proposalDTO.getInsuredPersonName() == null) {
            res.setMessage("Insured Person Name is required");
            res.setStatus("400");
            return res;
        }
//        insuredPerson.setPassportNo(proposalDTO.getPassportNo());
        insuredPerson.setIsChild(proposalDTO.getIsChild());
        insuredPerson.setBeneficiary(beneficiary);

        Country country2 = countryRepository.findCountryByCountryNameIgnoreCase(proposalDTO.getResidentCountry());
        if(proposalDTO.getResidentCountry() == null) {
            res.setMessage("Insured Person resident country is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setResidentCountry(country2);

        Country c = countryRepository.findCountryByCountryNameIgnoreCase(proposalDTO.getPassportIssuedCountry());
        if(proposalDTO.getPassportIssuedCountry() == null) {
            res.setMessage("Insured Person Passport Issued Country is required");
            res.setStatus("400");
            return res;
        }
        insuredPerson.setPassportIssuedCountry(c);


        insuredPersonRepository.save(insuredPerson);


        //child

        Child child = null;
        if (proposalDTO.getIsChild()) {
            child = new Child();
            if(proposalDTO.getChildName() == null) {
                res.setMessage("Child Name is required");
                res.setStatus("400");
                return res;
            }
            child.setChildName(proposalDTO.getChildName());

            if(proposalDTO.getChildDob() == null) {
                res.setMessage("Child dob is required");
                res.setStatus("400");
                return res;
            }
            child.setChildDob(proposalDTO.getChildDob());

            if(proposalDTO.getChildGender() == null) {
                res.setMessage("Child gender is required");
                res.setStatus("400");
                return res;
            }
            child.setChildGender(proposalDTO.getChildGender());

            if(proposalDTO.getGurdianceName() == null) {
                res.setMessage("Child Gurdiance Name is required");
                res.setStatus("400");
                return res;
            }
            child.setGurdianceName(proposalDTO.getGurdianceName());

            if(proposalDTO.getChildRelationship() == null) {
                res.setMessage("Child Relationship is required");
                res.setStatus("400");
                return res;
            }
            child.setChildRelationship(proposalDTO.getChildRelationship());

            child.setInsuredPerson(insuredPerson);

            childRepository.save(child);
        }

        InboundProposal inboundProposal = new InboundProposal();
        inboundProposal.setAge(proposalDTO.getAge());

        if(proposalDTO.getArrivalDate() == null) {
            res.setMessage("Arrival Date is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setArrivalDate(proposalDTO.getArrivalDate());
        inboundProposal.setCertificateNo(generateCertificateNo(inboundProposal));

        if(proposalDTO.getCoveragePlan() == 0) {
            res.setMessage("Coverage Plan is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setCoveragePlan(proposalDTO.getCoveragePlan());

        inboundProposal.setInsuredName(proposalDTO.getInsuredPersonName());
        inboundProposal.setPassportIssuedDate(proposalDTO.getPassportIssuedDate());
        inboundProposal.setPassportNo(proposalDTO.getPassportNo());
        inboundProposal.setPhoneNo(proposalDTO.getPhoneNo());

        if(proposalDTO.getPolicyStartDate() == null) {
            res.setMessage("Policy Start Date is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setPolicyStartDate(proposalDTO.getPolicyStartDate());

        if(proposalDTO.getPolicyEndDate() == null) {
            res.setMessage("Policy End Date is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setPolicyEndDate(proposalDTO.getPolicyEndDate());

        if(proposalDTO.getPremiumRate() == 0) {
            res.setMessage("Premium Rate is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setPremiumRate(proposalDTO.getPremiumRate());

        if(proposalDTO.getServiceFees() == null) {
            res.setMessage("Service Fees is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setServiceFees(proposalDTO.getServiceFees());

        if(proposalDTO.getSubmittedDate() == null) {
            res.setMessage("Submitted Date is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setSubmittedDate(proposalDTO.getSubmittedDate());
        inboundProposal.setPassportIssuedCountry(proposalDTO.getPassportIssuedCountry());


        Agent agent = agentRepository.findAgentByLicenceNo(proposalDTO.getLicenceNo());
        inboundProposal.setAgent(agent);

        inboundProposal.setBeneficiary(beneficiary);
        inboundProposal.setChild(child);
        inboundProposal.setInsuredPerson(insuredPerson);

        Country country = countryRepository.findCountryByCountryNameIgnoreCase(proposalDTO.getJourneyFrom());
        if(proposalDTO.getJourneyFrom() == null) {
            res.setMessage("Journey From is required");
            res.setStatus("400");
            return res;
        }
        inboundProposal.setJourneyfrom(country);

        inboundProposalRepository.save(inboundProposal);

        res.setMessage("Proposal Created");
        res.setStatus("201");
        return res;
    }

    private String generateCertificateNo(InboundProposal inboundProposal) {
        LocalDate now = LocalDate.now();
        String year = now.format(DateTimeFormatter.ofPattern("yyyy"));
        String month = now.format(DateTimeFormatter.ofPattern("MM"));
        return "ITA/" + inboundProposal.getId() + month + "-" + year;
    }


}
