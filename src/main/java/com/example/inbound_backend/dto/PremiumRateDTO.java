package com.example.inbound_backend.dto;

import com.example.inbound_backend.entity.InsuredPerson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PremiumRateDTO {
    private int age;
    private int days;
    private double rate;

    private AgentDTO gentD;
}
