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
@Table(name="agent")
public class Agent extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String agentId;
    private String licenceNo;
    private String agentName;
    private String password;

    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<InboundProposal> inboundProposalList;
}
