package com.example.inbound_backend.controller;

import com.example.inbound_backend.dto.ProposalDTO;
import com.example.inbound_backend.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProposalController {
    @Autowired
    private ProposalService proposalService;

    @PostMapping("/proposal")
    public List<ProposalDTO> findall(@RequestBody ProposalDTO proposalDTO) throws Exception{
        return proposalService.findAllProposal(proposalDTO);
    }




}
