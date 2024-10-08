package com.example.inbound_backend.repository;

import com.example.inbound_backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,String> {
    List<Country> findAll();
    Country findCountryByCountryNameIgnoreCase(String name);
//    Country findCountryById(String id, String residentCountryId);


}
