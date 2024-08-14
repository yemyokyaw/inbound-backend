package com.example.inbound_backend.controller;

import com.example.inbound_backend.dto.PremiumRateDTO;
import com.example.inbound_backend.service.PremiumRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PremiumController {
    @Autowired
    private PremiumRateService premiumRateService;

    @PostMapping("/premium")
    public ResponseEntity<PremiumRateDTO> findPremiumRate(@ModelAttribute PremiumRateDTO premiumRateDTO){
        return ResponseEntity.ok(premiumRateService.getPremiumRate(premiumRateDTO));
    }
}
