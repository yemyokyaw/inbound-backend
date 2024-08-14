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
@Table(name="insured_person")
public class InsuredPerson extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String insuredId;
    private String insuredName;
    private LocalDate insuredDob;
    private String insuredGender;
    private String localAddress;
    private String foreignAddress;
    private String insuredEmail;
    private String insuredPhoneNo;
    private String passportNo;
    private LocalDate passportIssuedDate;
    private Boolean isChild;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JsonBackReference
    @JoinColumn(name = "passport_country_id")
    private Country passportIssuedCountry;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JsonBackReference
    @JoinColumn(name = "resident_country_id")
    private Country residentCountry;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;


}
