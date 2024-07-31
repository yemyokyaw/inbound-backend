package com.example.inbound_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="inbound_proposal")
public class InboundProposal extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date arrivalDate;
    @Column(columnDefinition = "varchar(255) default 'MYANMAR'")
    private String journeyTo ;
    private double serviceFees;
    private Date policyStartDate;
    private Date getPolicyEndDate;
    private Date submittedDate;
    private int coveragePlan;
    private int premiumRate;
    private String certificateNo;
    private String passportNo;
    private Date passportIssuedDate;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "insured_person_id")
    private InsuredPerson insuredPerson;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    private Child child;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JsonBackReference
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JsonBackReference
    @JoinColumn(name = "journey_from")
    private Country journeyfrom;



}
