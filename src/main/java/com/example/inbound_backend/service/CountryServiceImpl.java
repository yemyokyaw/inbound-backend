package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.CountryDTO;
import com.example.inbound_backend.entity.Country;
import com.example.inbound_backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryDTO> getAllCountry() throws Exception {

        List<Country> countryList = countryRepository.findAll();
        if(countryList == null) throw new Exception("Country not found");

        List<CountryDTO> countryDTOList = new ArrayList<>();

        for(Country c : countryList){
            CountryDTO countryDTO =new CountryDTO();

            countryDTO.setName(c.getName());
            countryDTO.setCountryCode(c.getCountryCode());

            countryDTOList.add(countryDTO);
        }

        return countryDTOList;


    }
}
