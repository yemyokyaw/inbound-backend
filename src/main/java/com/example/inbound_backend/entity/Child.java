package com.example.inbound_backend.entity;

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
@Table(name="child")
public class Child extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String childId;
    private String childName;
    private LocalDate childDob;
    private String childGender;
    private String gurdianceName;
    private String childRelationship;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "insuredPerson")
    private InsuredPerson insuredPerson;



}
