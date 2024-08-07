package com.example.inbound_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProposalDTO {
    private String certificateNo;
//    private String name;
    private int age;
    private String phoneNo;
    private int coveragePlan;
    private int premiumRate;
    private LocalDate submittedDate;
    private String passportNo;
    private String passportIssuedCountry;
    private LocalDate policyEndDate;
    private LocalDate policyStartDate;
    private LocalDate arrivalDate;
    private Double serviceFees;

    //beneficiary
    private String beneficiaryName;
    private String beneficiaryGender;
    private LocalDate beneficiarydob;
    private String nin;
    private String address;
    private String beneficiaryEmail;
    private String beneficiaryPhNo;
    private String relationship;

    //insuredPerson
    private String insuredPersonName;
    private LocalDate insuredPersondob;
    private String insuredPersongender;
    private String localaddress;
    private String foreignAddress;
    private String insuredPersonEmail;
    private String insuredPersonPhNo;
    private LocalDate passportIssuedDate;
    private Boolean isChild;
    private String insuredPersonPassportno;

    //child
    private String childName;
    private LocalDate childDob;
    private String childGender;
    private String gurdianceName;
    private String childRelationship;

    //agnet
    private String licenceNo;
    private String agentName;
    //country
    private String journeyFrom;
    private String passportCountry;
    private String residentCountry;
    private String benefiCountry;



}
