package com.example.inbound_backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AgentDTO {
    private String licenceNo;
    private String name;
    private String password;
}
