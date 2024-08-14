package com.example.inbound_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="country")
public class Country extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String countryId;
    private String countryName;
    private String countryCode;

    @OneToMany(mappedBy = "passportIssuedCountry", fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<InsuredPerson> insuredPersonPassportList;

    @OneToMany(mappedBy = "residentCountry", fetch =FetchType.EAGER,cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<InsuredPerson> insuredPersonResidentList;

    @OneToMany(mappedBy = "residentCountry", fetch =FetchType.EAGER,cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Beneficiary> beneficiaryList;

    @OneToMany(mappedBy = "journeyfrom", fetch =FetchType.EAGER,cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<InboundProposal> inboundProposalList;
}
