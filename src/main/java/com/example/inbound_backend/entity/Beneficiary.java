package com.example.inbound_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="beneficiary")
public class Beneficiary extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String beneficiaryId;
    private String beneficiaryName;
    private LocalDate beneficiaryDob;
    private String nin;
    private String beneficiaryAddress;
    private String beneficiaryEmail;
    private String beneficiaryPhoneNo;
    private String beneficiaryRelationship;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JsonBackReference
    @JoinColumn(name = "resident_country_id")
    private Country residentCountry;

}
