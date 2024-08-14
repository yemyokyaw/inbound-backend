package com.example.inbound_backend.controller;

import com.example.inbound_backend.dto.ProposalDTO;
import com.example.inbound_backend.dto.ResponseDTO;
import com.example.inbound_backend.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProposalController {
    @Autowired
    private ProposalService proposalService;

    @PostMapping("/proposal/enquiry")
    public ResponseEntity<List<ProposalDTO>> findall(@ModelAttribute ProposalDTO proposalDTO) throws Exception {
        return ResponseEntity.ok(proposalService.findAllProposal(proposalDTO));
    }

    @PostMapping("/proposal")
    public ResponseEntity<ResponseDTO> proposalCreate(@ModelAttribute ProposalDTO proposalDTO) throws Exception {
        return new ResponseEntity<>(proposalService.createProposal(proposalDTO), HttpStatus.OK);

    }
}
