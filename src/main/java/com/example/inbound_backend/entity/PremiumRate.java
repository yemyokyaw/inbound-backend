package com.example.inbound_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="premium_rate")
public class PremiumRate extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  id;
    private int days;
    private int fromAge;
    private int toAge;
    private double rate;




}
