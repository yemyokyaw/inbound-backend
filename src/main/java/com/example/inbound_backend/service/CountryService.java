package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.CountryDTO;

import java.util.List;

public interface CountryService {
   List<CountryDTO> getAllCountry() throws Exception;
}
