package com.example.inbound_backend.controller;

import com.example.inbound_backend.dto.CountryDTO;
import com.example.inbound_backend.entity.Country;
import com.example.inbound_backend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public ResponseEntity<List<CountryDTO>> findAllCountry () throws Exception {
        return ResponseEntity.ok(countryService.getAllCountry());
    }
}
