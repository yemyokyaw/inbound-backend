package com.example.inbound_backend.service;

import com.example.inbound_backend.dto.PremiumRateDTO;
import com.example.inbound_backend.entity.PremiumRate;
import com.example.inbound_backend.repository.PremiumRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumRateServiceImpl implements PremiumRateService{
    @Autowired
    private PremiumRateRepository premiumRateRepository;

    @Override
    public PremiumRateDTO getPremiumRate(PremiumRateDTO premiumRateDTO) {
        PremiumRate premiumRate =  premiumRateRepository.findByDays(premiumRateDTO.getDays(),premiumRateDTO.getAge());
        PremiumRateDTO rateDTO = new PremiumRateDTO();
        rateDTO.setRate(premiumRate.getRate());
        rateDTO.setDays(premiumRate.getDays());
        rateDTO.setAge(premiumRateDTO.getAge());

        return rateDTO;
    }
}
