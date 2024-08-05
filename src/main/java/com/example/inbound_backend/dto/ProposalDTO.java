package com.example.inbound_backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
