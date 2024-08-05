package com.example.inbound_backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.lang.model.element.NestingKind;
import java.util.Date;

@Getter
@Setter
@ToString
public class ProposalDTO {
    private String certificateNo;
    private String name;
    private int age;
    private int phoneNo;
    private int coveragePlan;
    private int premiumRate;
    private Date submittedDate;
    private String passportNo;
    private String passportIssuedCountry;

    //beneficiary
    private String beneficiaryName;
    private String beneficiaryGender;
    private Date beneficiarydob;
    private String nin;
    private String address;
    private String ebeneficiaryEmail;
    private int beneficiaryPhNo;
    private String relationship;

    //insuredPerson
    private String insuredPersonName;
    private Date insuredPersondob;
    private String insuredPersongender;
    private String localaddress;
    private String foreignAddress;
    private String insuredPersonEmail;
    private int insuredPersonPhNo;
    private Date passportIssuedDate;
    private Boolean isChild;


}
